CREATE TABLE shipaorder (
  id bigint NOT NULL AUTO_INCREMENT,
  customerrefno varchar(60) DEFAULT NULL,
  ordertype varchar(60) DEFAULT NULL,
  category varchar(60) DEFAULT NULL,
  origincontactname varchar(60) DEFAULT NULL,
  origincontactno varchar(60) DEFAULT NULL,
  origincity varchar(60) DEFAULT NULL,
  origincountry varchar(60) DEFAULT NULL,
  originaddress varchar(60) DEFAULT NULL,
  destinationcontactname varchar(60) DEFAULT NULL,
  destinationcontactno varchar(60) DEFAULT NULL,
  destinationcity varchar(60) DEFAULT NULL,
  destinationcountry varchar(60) DEFAULT NULL,
  destinationaddress varchar(60) DEFAULT NULL,
  shipaapistatus varchar(60) DEFAULT NULL,
  shiparef varchar(60) DEFAULT NULL,
  awbpdf BLOB DEFAULT NULL,
  createdBy varchar(60) DEFAULT NULL,
  creationDate datetime DEFAULT NULL,
  lastModifiedBy varchar(60) DEFAULT NULL,
  lastModifiedDate datetime DEFAULT NULL,
  PRIMARY KEY (id)
);
/
CREATE TABLE shipaorderpackages (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(60) DEFAULT NULL,
  customerrefno varchar(60) DEFAULT NULL,
  shipaorderid bigint DEFAULT NULL,
  createdBy varchar(60) DEFAULT NULL,
  creationDate datetime DEFAULT NULL,
  lastModifiedBy varchar(60) DEFAULT NULL,
  lastModifiedDate datetime DEFAULT NULL,
  PRIMARY KEY (id),
  constraint `shipaorderpackagesfk1` foreign key (`shipaorderid`) references `shipaorder` (`id`)
);
/