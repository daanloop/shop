
    create table ATTACHMENT (
        ID INTEGER not null auto_increment,
        FILETYPE VARCHAR(255) BINARY not null,
        WIDTH FLOAT not null,
        HEIGHT FLOAT not null,
        WIDE TINYINT not null,
        DB_FILE_FK INTEGER unique,
        ASDETAILED_FK INTEGER,
        primary key (ID)
    ) type=InnoDB;

    create table CARRIAGE (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        VALUE INTEGER not null,
        primary key (ID)
    ) type=InnoDB;

    create table CATEGORY (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        primary key (ID)
    ) type=InnoDB;

    create table CHOISE (
        ID INTEGER not null auto_increment,
        ORDERNUM INTEGER not null,
        PRICEWITHTAX INTEGER not null,
        WRAPPING TINYINT not null,
        PURCHASE_FK INTEGER not null,
        ITEM_FK INTEGER not null,
        primary key (ID)
    ) type=InnoDB;

    create table DB_FILE (
        ID INTEGER not null auto_increment,
        DATA LONGBLOB not null,
        primary key (ID)
    ) type=InnoDB;

    create table DELIVERY_ADDRESS (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        KANA VARCHAR(255) BINARY not null,
        ZIPTHREE INTEGER not null,
        ZIPFOUR INTEGER not null,
        PHONE VARCHAR(255) BINARY not null,
        ADDRESS VARCHAR(255) BINARY not null,
        BUILDINGNAME VARCHAR(255) BINARY not null,
        PREF VARCHAR(255) BINARY not null,
        PREFERREDDATE VARCHAR(255) BINARY not null,
        PREFERREDTIME VARCHAR(255) BINARY not null,
        HASGIFTCARD TINYINT not null,
        PUBLIC_USER_FK INTEGER not null,
        GIFT_CARD_FK INTEGER,
        PREFECTURE_FK INTEGER,
        primary key (ID)
    ) type=InnoDB;

    create table DELIVERY_ADDRESS_CHOISE (
        ID INTEGER not null auto_increment,
        ORDERNUM INTEGER not null,
        PREFERREDDATE VARCHAR(255) BINARY not null,
        PREFERREDTIME VARCHAR(255) BINARY not null,
        DELIVERY_ADDRESS_FK INTEGER not null,
        CHOISE_FK INTEGER not null,
        GIFT_CARD_FK INTEGER,
        primary key (ID)
    ) type=InnoDB;

    create table GIFT_CARD (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        primary key (ID)
    ) type=InnoDB;

    create table ITEM (
        ID INTEGER not null auto_increment,
        NO VARCHAR(255) BINARY not null,
        NAME VARCHAR(255) BINARY not null,
        PRICEWITHTAX INTEGER not null,
        SIZE VARCHAR(255) BINARY not null,
        MATERIAL VARCHAR(255) BINARY not null,
        CATCHCOPY VARCHAR(2000 ) BINARY not null,
        DESCRIPTION VARCHAR(2000 ) BINARY not null,
        NOTE VARCHAR(2000 ) BINARY not null,
        STOCKNUM INTEGER not null,
        MAIN TINYINT not null,
        PRODUCT_FK INTEGER not null,
        CARRIAGE_FK INTEGER,
        ZOOM_FK INTEGER unique,
        DEFAULTATTACHMENT_FK INTEGER unique,
        primary key (ID)
    ) type=InnoDB;

    create table PAYMENT_METHOD (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        NOTE VARCHAR(2000) BINARY not null,
        primary key (ID)
    ) type=InnoDB;

    create table PREFECTURE (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        primary key (ID)
    ) type=InnoDB;

    create table PRODUCT (
        ID INTEGER not null auto_increment,
        NO VARCHAR(255) BINARY not null,
        NAME VARCHAR(255) BINARY not null,
        DATE DATETIME not null,
        PUB TINYINT not null,
        PRICEWITHTAX INTEGER not null,
        SIZE VARCHAR(255) BINARY not null,
        MATERIAL VARCHAR(255) BINARY not null,
        CATCHCOPY VARCHAR(2000 ) BINARY not null,
        DESCRIPTION VARCHAR(2000 ) BINARY not null,
        NOTE VARCHAR(2000 ) BINARY not null,
        STOCKNUM INTEGER not null,
        REMOVED TINYINT not null,
        MAINITEMNAME VARCHAR(255) BINARY not null,
        CATEGORY_FK INTEGER,
        THUMNAIL_FK INTEGER unique,
        SLIDESHOW_FK INTEGER unique,
        primary key (ID)
    ) type=InnoDB;

    create table PUBLIC_USER (
        ID INTEGER not null auto_increment,
        NAME VARCHAR(255) BINARY not null,
        KANA VARCHAR(255) BINARY not null,
        ZIPTHREE INTEGER not null,
        ZIPFOUR INTEGER not null,
        PREF VARCHAR(255) BINARY not null,
        ADDRESS VARCHAR(255) BINARY not null,
        BUILDINGNAME VARCHAR(255) BINARY not null,
        MAIL VARCHAR(255) BINARY not null,
        MAILFORCONFIRM VARCHAR(255) BINARY not null,
        PHONE VARCHAR(255) BINARY not null,
        DEVLIVERYHOUR INTEGER not null,
        DELIVERYDATE INTEGER not null,
        DELIVERYPHONE INTEGER not null,
        DELIVERYKANA VARCHAR(255) BINARY not null,
        DELIVERYBLOCKNUMBER VARCHAR(255) BINARY not null,
        DELIVERYADDRESS VARCHAR(255) BINARY not null,
        DELIVERYNAME VARCHAR(255) BINARY not null,
        DELIVERYZIPFOUR INTEGER not null,
        DELIVERYZIPTHREE INTEGER not null,
        DELIVERYPREF VARCHAR(255) BINARY not null,
        DELIVERTODIFFERENTADDRESS TINYINT not null,
        MALE TINYINT not null,
        BRITHDAY INTEGER not null,
        BIRTHMONTH INTEGER not null,
        MUNICIPALITY VARCHAR(255) BINARY not null,
        BIRTHYEAR INTEGER not null,
        KEITAI VARCHAR(255) BINARY not null,
        REMOVED TINYINT not null,
        PASSWORD VARCHAR(255) BINARY not null,
        FAX VARCHAR(255) BINARY not null,
        REGISTED TINYINT not null,
        TEMP TINYINT not null,
        PASSWORDONETIMEHASH VARCHAR(255) BINARY not null,
        PREFECTURE_FK INTEGER,
        primary key (ID)
    ) type=InnoDB;

    create table PURCHASE (
        ID INTEGER not null auto_increment,
        TOTAL INTEGER not null,
        CARRIAGE INTEGER not null,
        TOTALORDERNUM INTEGER not null,
        SHIPPED TINYINT not null,
        DATE DATETIME not null,
        TEMP TINYINT not null,
        CANCELLED TINYINT not null,
        REMOVED TINYINT not null,
        PUBLIC_USER_FK INTEGER,
        PAYMENT_METHOD_FK INTEGER,
        primary key (ID)
    ) type=InnoDB;

    create table STATIC_DATA (
        ID INTEGER not null auto_increment,
        FROMADDRESS VARCHAR(255) BINARY not null,
        SITENAME VARCHAR(255) BINARY not null,
        BASEPATH VARCHAR(255) BINARY not null,
        UNIX TINYINT not null,
        MAPEVENTSPAN INTEGER not null,
        NOIMAGE LONGBLOB not null,
        CARRIAGE INTEGER not null,
        CREDITCARDPROCESURL VARCHAR(255) BINARY not null,
        CONTRACT_CODE VARCHAR(255) BINARY not null,
        primary key (ID)
    ) type=InnoDB;

    alter table ATTACHMENT 
        add index ATTACHMENT_DB_FILE_FKC (DB_FILE_FK), 
        add constraint ATTACHMENT_DB_FILE_FKC 
        foreign key (DB_FILE_FK) 
        references DB_FILE (ID);

    alter table ATTACHMENT 
        add index ATTACHMENT_ASDETAILED_FKC (ASDETAILED_FK), 
        add constraint ATTACHMENT_ASDETAILED_FKC 
        foreign key (ASDETAILED_FK) 
        references ITEM (ID);

    alter table CHOISE 
        add index CHOISE_PURCHASE_FKC (PURCHASE_FK), 
        add constraint CHOISE_PURCHASE_FKC 
        foreign key (PURCHASE_FK) 
        references PURCHASE (ID);

    alter table CHOISE 
        add index CHOISE_ITEM_FKC (ITEM_FK), 
        add constraint CHOISE_ITEM_FKC 
        foreign key (ITEM_FK) 
        references ITEM (ID);

    alter table DELIVERY_ADDRESS 
        add index DELIVERY_ADDRESS_PUBLIC_USER_C (PUBLIC_USER_FK), 
        add constraint DELIVERY_ADDRESS_PUBLIC_USER_C 
        foreign key (PUBLIC_USER_FK) 
        references PUBLIC_USER (ID);

    alter table DELIVERY_ADDRESS 
        add index DELIVERY_ADDRESS_PREFECTURE_FC (PREFECTURE_FK), 
        add constraint DELIVERY_ADDRESS_PREFECTURE_FC 
        foreign key (PREFECTURE_FK) 
        references PREFECTURE (ID);

    alter table DELIVERY_ADDRESS 
        add index DELIVERY_ADDRESS_GIFT_CARD_FKC (GIFT_CARD_FK), 
        add constraint DELIVERY_ADDRESS_GIFT_CARD_FKC 
        foreign key (GIFT_CARD_FK) 
        references GIFT_CARD (ID);

    alter table DELIVERY_ADDRESS_CHOISE 
        add index DELIVERY_ADDRESS_CHOISE_DELIVC (DELIVERY_ADDRESS_FK), 
        add constraint DELIVERY_ADDRESS_CHOISE_DELIVC 
        foreign key (DELIVERY_ADDRESS_FK) 
        references DELIVERY_ADDRESS (ID);

    alter table DELIVERY_ADDRESS_CHOISE 
        add index DELIVERY_ADDRESS_CHOISE_GIFT_C (GIFT_CARD_FK), 
        add constraint DELIVERY_ADDRESS_CHOISE_GIFT_C 
        foreign key (GIFT_CARD_FK) 
        references GIFT_CARD (ID);

    alter table DELIVERY_ADDRESS_CHOISE 
        add index DELIVERY_ADDRESS_CHOISE_CHOISC (CHOISE_FK), 
        add constraint DELIVERY_ADDRESS_CHOISE_CHOISC 
        foreign key (CHOISE_FK) 
        references CHOISE (ID);

    alter table ITEM 
        add index ITEM_CARRIAGE_FKC (CARRIAGE_FK), 
        add constraint ITEM_CARRIAGE_FKC 
        foreign key (CARRIAGE_FK) 
        references CARRIAGE (ID);

    alter table ITEM 
        add index ITEM_ZOOM_FKC (ZOOM_FK), 
        add constraint ITEM_ZOOM_FKC 
        foreign key (ZOOM_FK) 
        references ATTACHMENT (ID);

    alter table ITEM 
        add index ITEM_DEFAULTATTACHMENT_FKC (DEFAULTATTACHMENT_FK), 
        add constraint ITEM_DEFAULTATTACHMENT_FKC 
        foreign key (DEFAULTATTACHMENT_FK) 
        references ATTACHMENT (ID);

    alter table ITEM 
        add index ITEM_PRODUCT_FKC (PRODUCT_FK), 
        add constraint ITEM_PRODUCT_FKC 
        foreign key (PRODUCT_FK) 
        references PRODUCT (ID);

    alter table PRODUCT 
        add index PRODUCT_SLIDESHOW_FKC (SLIDESHOW_FK), 
        add constraint PRODUCT_SLIDESHOW_FKC 
        foreign key (SLIDESHOW_FK) 
        references ATTACHMENT (ID);

    alter table PRODUCT 
        add index PRODUCT_THUMNAIL_FKC (THUMNAIL_FK), 
        add constraint PRODUCT_THUMNAIL_FKC 
        foreign key (THUMNAIL_FK) 
        references ATTACHMENT (ID);

    alter table PRODUCT 
        add index PRODUCT_CATEGORY_FKC (CATEGORY_FK), 
        add constraint PRODUCT_CATEGORY_FKC 
        foreign key (CATEGORY_FK) 
        references CATEGORY (ID);

    alter table PUBLIC_USER 
        add index PUBLIC_USER_PREFECTURE_FKC (PREFECTURE_FK), 
        add constraint PUBLIC_USER_PREFECTURE_FKC 
        foreign key (PREFECTURE_FK) 
        references PREFECTURE (ID);

    alter table PURCHASE 
        add index PURCHASE_PUBLIC_USER_FKC (PUBLIC_USER_FK), 
        add constraint PURCHASE_PUBLIC_USER_FKC 
        foreign key (PUBLIC_USER_FK) 
        references PUBLIC_USER (ID);

    alter table PURCHASE 
        add index PURCHASE_PAYMENT_METHOD_FKC (PAYMENT_METHOD_FK), 
        add constraint PURCHASE_PAYMENT_METHOD_FKC 
        foreign key (PAYMENT_METHOD_FK) 
        references PAYMENT_METHOD (ID);
