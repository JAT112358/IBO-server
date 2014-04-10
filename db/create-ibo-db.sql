CREATE DATABASE tralaladb;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON iboDB.*
           TO admin@'%'
           IDENTIFIED BY 'ibobilbao';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON admin.*
           TO sd@localhost
           IDENTIFIED BY 'ibobilbao';