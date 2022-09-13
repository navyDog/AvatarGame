CREATE TABLE bank_item(
   bank_item_id      INTEGER  NOT NULL PRIMARY KEY 
  ,bank_item_membre  INTEGER  NOT NULL
  ,bank_item_name    VARCHAR(45) NOT NULL
  ,bank_item_picture VARCHAR(13) NOT NULL
  ,bank_item_rarity  INTEGER  NOT NULL
);