package com.github.mars05.crud.intellij.plugin.ui;

import com.github.mars05.crud.intellij.plugin.icon.CrudIcons;
import com.github.mars05.crud.intellij.plugin.setting.Conn;
import com.github.mars05.crud.intellij.plugin.setting.CrudSettings;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author xiaoyu
 */
public class CrudConnView implements CrudView {
    private JPanel myMainPanel;
    private JButton myAddConnButton;
    private JList myConnsList;
    private JScrollPane myScrollPane;
    private JLabel myConnLabel;
    private JButton myEditConnButton;
    private JButton myRemoveConnButton;

    public CrudConnView() {
        myAddConnButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrudAddConnDialog dialog = new CrudAddConnDialog(CrudConnView.this);
                if (!dialog.showAndGet()) {
                    return;
                }
            }
        });
        myEditConnButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = getCrudList().getSelectedIndex();
                if (index == -1) {
                    Messages.showErrorDialog(myMainPanel, "Please select a connection to modify");
                    return;
                }
                Conn conn = CrudSettings.getInstance().getConns().get(index);
                CrudEditConnDialog dialog = new CrudEditConnDialog(CrudConnView.this, conn);
                if (!dialog.showAndGet()) {
                    return;
                }
            }
        });
        myRemoveConnButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = getCrudList().getSelectedIndex();
                if (index == -1) {
                    Messages.showErrorDialog(myConnsList, "Please select a connection to delete");
                    return;
                }
                int result = Messages.showYesNoDialog(getCrudList().getSelectedElement().getName(), "confirm deletion？", Messages.getQuestionIcon());
                if (result == Messages.YES) {
                    CrudSettings.getInstance().getConns().remove(index);
                    CrudList crudList = getCrudList();
                    crudList.clearElement();
                    List<Conn> conns = CrudSettings.getInstance().getConns();
                    for (Conn conn : conns) {
                        crudList.addElement(new ListElement(CrudIcons.MYSQL_CONN, conn.getName()));
                    }
                }
            }
        });
    }

    @Override
    public CrudList getCrudList() {
        return (CrudList) myConnsList;
    }

    @Override
    public JComponent getComponent() {
        return myMainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        myScrollPane = new JBScrollPane();
        myConnLabel = new JBLabel();
    }
}
