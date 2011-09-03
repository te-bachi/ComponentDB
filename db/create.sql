
DROP TABLE sequence;
DROP TABLE price;
DROP TABLE component_has_value;
DROP TABLE attribute_value;
DROP TABLE group_has_attribute;
DROP TABLE attribute;
DROP TABLE component_has_attachment;
DROP TABLE attachment;
DROP TABLE component;
DROP TABLE distributor;
DROP TABLE country;
DROP TABLE currency;
DROP TABLE manufacturer;
DROP TABLE category;
DROP TABLE attribute_group;

CREATE TABLE currency (
  id                INT UNSIGNED        NOT NULL,
  name              CHAR(3)             NOT NULL,
  rate              DECIMAL(8,4)        NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE country (
  id                INT UNSIGNED        NOT NULL,
  currency_id       INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  flag              MEDIUMBLOB          NOT NULL,
  tax_rate          DECIMAL(8,4)        NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(currency_id) REFERENCES currency(id)
);

CREATE TABLE distributor (
  id                INT UNSIGNED        NOT NULL,
  country_id        INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  picture           MEDIUMBLOB          NOT NULL,
  with_taxes        BOOLEAN             NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(country_id) REFERENCES country(id)
);

CREATE TABLE attribute_group (
  id                INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  PRIMARY KEY(id),
  UNIQUE KEY(name)
);

CREATE TABLE category (
  id                INT UNSIGNED        NOT NULL,
  parent_id         INT UNSIGNED        NULL,
  attribute_group_id INT UNSIGNED        NULL,
  name              VARCHAR(64)         NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(parent_id) REFERENCES category(id),
  FOREIGN KEY(attribute_group_id) REFERENCES attribute_group(id),
  UNIQUE KEY(name)
);

CREATE TABLE manufacturer (
  id                INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  PRIMARY KEY(id),
  UNIQUE KEY(name)
);

CREATE TABLE component (
  id                INT UNSIGNED        NOT NULL,
  category_id       INT UNSIGNED        NOT NULL,
  manufacturer_id   INT UNSIGNED        NOT NULL,
  distributor_id    INT UNSIGNED        NOT NULL,
  part_number       VARCHAR(32)         NULL,
  name              VARCHAR(32)         NOT NULL,
  description       VARCHAR(255)        NOT NULL,
  place             VARCHAR(32)         NULL,
  quantity          SMALLINT UNSIGNED   NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(distributor_id) REFERENCES distributor(id),
  FOREIGN KEY(category_id) REFERENCES category(id),
  FOREIGN KEY(manufacturer_id) REFERENCES manufacturer(id)
);

CREATE TABLE attachment (
  id                INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  type              TINYINT UNSIGNED    NOT NULL,
  content_type      VARCHAR(32)         NOT NULL,
  content           LONGBLOB            NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE component_has_attachment (
  component_id      INT UNSIGNED        NOT NULL,
  attachment_id     INT UNSIGNED        NOT NULL,
  FOREIGN KEY(component_id) REFERENCES component(id),
  FOREIGN KEY(attachment_id) REFERENCES attachment(id)
);

CREATE TABLE attribute (
  id                INT UNSIGNED        NOT NULL,
  name              VARCHAR(32)         NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE group_has_attribute (
  attribute_group_id INT UNSIGNED        NOT NULL,
  attribute_id      INT UNSIGNED        NOT NULL,
  FOREIGN KEY(attribute_group_id) REFERENCES attribute_group(id),
  FOREIGN KEY(attribute_id) REFERENCES attribute(id)
);

CREATE TABLE attribute_value (
  id                INT UNSIGNED        NOT NULL,
  attribute_id      INT UNSIGNED        NOT NULL,
  value             VARCHAR(32)         NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(attribute_id) REFERENCES attribute(id)
);

CREATE TABLE component_has_value (
  component_id      INT UNSIGNED        NOT NULL,
  attribute_value_id INT UNSIGNED        NOT NULL,
  FOREIGN KEY(component_id) REFERENCES component(id),
  FOREIGN KEY(attribute_value_id) REFERENCES attribute_value(id)
);

CREATE TABLE price (
  id                INT UNSIGNED        NOT NULL,
  component_id      INT UNSIGNED        NOT NULL,
  quantity          SMALLINT UNSIGNED   NOT NULL,
  price             DECIMAL(8,4)        NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(component_id) REFERENCES component(id)
);

CREATE TABLE sequence (
  seq_name          VARCHAR(32)         NOT NULL,
  seq_value         INTEGER             NOT NULL,
  PRIMARY KEY(seq_name)
);

INSERT INTO sequence VALUES ('SEQ_ATTACHMENT', 0);
INSERT INTO sequence VALUES ('SEQ_ATTRIBUTE', 0);
INSERT INTO sequence VALUES ('SEQ_ATTRIBUTE_CHOICE', 0);
INSERT INTO sequence VALUES ('SEQ_ATTRIBUTE_GROUP', 0);
INSERT INTO sequence VALUES ('SEQ_ATTRIBUTE_VALUE', 0);
INSERT INTO sequence VALUES ('SEQ_CATEGORY', 0);
INSERT INTO sequence VALUES ('SEQ_COMPONENT', 0);
INSERT INTO sequence VALUES ('SEQ_COUNTRY', 0);
INSERT INTO sequence VALUES ('SEQ_CURRENCY', 0);
INSERT INTO sequence VALUES ('SEQ_DISTRIBUTOR', 0);
INSERT INTO sequence VALUES ('SEQ_PRICE', 0);
