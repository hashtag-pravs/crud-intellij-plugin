package com.github.mars05.crud.intellij.plugin.step;

import com.github.mars05.crud.intellij.plugin.model.Column;
import com.github.mars05.crud.intellij.plugin.model.Table;
import com.github.mars05.crud.intellij.plugin.ui.CrudList;
import com.github.mars05.crud.intellij.plugin.ui.CrudTableView;
import com.github.mars05.crud.intellij.plugin.ui.ListElement;
import com.github.mars05.crud.intellij.plugin.util.DbHelper;
import com.github.mars05.crud.intellij.plugin.util.SelectionContext;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoyu
 */
public class CrudTableStep extends ModuleWizardStep {

    private CrudTableView myCrudTableView;

    public CrudTableStep(CrudTableView crudTableView) {
        myCrudTableView = crudTableView;
    }

    @Override
    public JComponent getComponent() {
        return myCrudTableView.getComponent();
    }

    @Override
    public void updateDataModel() {

    }

    public void reloadListElements(List<ListElement> listElements) {
        CrudList crudList = myCrudTableView.getCrudList();
        crudList.clearElement();

        if (listElements != null) {
            for (ListElement listElement : listElements) {
                crudList.addElement(listElement);
            }
        }
    }

    public void reloadPathLabel(String str) {
        myCrudTableView.getPathLabel().setText(str);
    }

    private DbHelper dbHelper;

    public void reloadDbHelper(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public boolean validate() throws ConfigurationException {
        try {
            List<ListElement> elements = myCrudTableView.getCrudList().getSelectedValuesList();
            if (elements == null || elements.size() == 0) {
                throw new Exception("Please select at least one table");
            }
            List<Table> tables = new Vector<>();
            CountDownLatch latch = new CountDownLatch(elements.size());
            for (ListElement element : elements) {
                // threading
                new Thread(() -> {
                    tables.add(dbHelper.getTable(element.getName()));
                    latch.countDown();
                }).start();
            }
            if (!latch.await(10L, TimeUnit.SECONDS)) {
                throw new Exception("Obtain" + elements.size() + "table failed");
            }

            for (Table table : tables) {
                List<Column> columns = table.getColumns();
                boolean hasId = false;
                for (Column column : columns) {
                    if (column.isId()) {
                        hasId = true;
                        break;
                    }
                }
                if (!hasId) {
                    throw new Exception("table: " + table.getName() + " no primary key");
                }
            }
            SelectionContext.setTables(tables);
        } catch (Exception e) {
            throw new ConfigurationException(e.getMessage(), "table selection failed");
        }
        return super.validate();
    }
}
