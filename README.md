CRUD Intellij Plugin
===============
A plug-in that adds a modified reservation, can help you quickly generate related code according to the database table structure.

There are two ways to use:
- Generate projects from crud plugin
- Extemplation Right click to generate code

### Notice: 
1. Currently, the mapping relationship settings for field types are not supported.
2. Currently do not support the corresponding relationship processing between tables
3. Set the appropriate annotation for the tables and fields.
4. It is recommended to design a database table according to the "Alibaba Java Development Manual".

### Support environment
Environment | version
--- | ---
Java | 1.8 or more
Intellij Idea | 2017.3 or more

## plugin installation
#### Older version IDEA:
  - <kbd> file </ kbd>> <kbd> settings </ kbd>> <kbd> plugins </ kbd>> <kbd> browse repositories ... </ kbd>> <kbd> search for "crud" < / KBD>> <KBD> Install plugin </ kBD>

! [Image] (https://Raw.githubuserContent.com/mars05/static/master/image/crud1.jpg)
#### New version IDEA:
  - <kbd> file </ kbd>> <kbd> settings </ kbd>> <kbd> plugins </ kbd>> <kbd> marketplace </ kbd>> <kbd> search for "crud" </ kbd>> <KBD> Install Plugin </ KBD>
  
! [image] (https://Raw.githubuserContent.com/mars05/static/master/image/crud2.jpg)
#### Local installation:
Download plugin file [crud-plugin] (https://github.com/mars05/crud-intellij-plugin/releases/download/v1.1.0/crud-plugin-1.1.0.zip)
## Using tutorial

### 1. Create a new project:
  - <kBD> New </ kbd>> <kbd> Project </ kbd> / <kbd> module </ kbd>> <kbd> crud </ kbd>> <kbd> database table selection </ kBd>
  - Start Application
  - Can use Swagger test request: http: // localhost: 8080 / swagger-ui.html

! [image] (https://raw.githubuserContent.com/mars05/static/master/image/crud3.gif)

### 2. Project Right-click Generation Code:

! [image] (https://Raw.githubuserContent.com/mars05/static/master/image/crud4.gif)