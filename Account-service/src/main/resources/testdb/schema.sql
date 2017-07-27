drop table ACCOUNT if exists;

create table ACCOUNT (ACCOUNTID bigint identity primary key, NAME varchar(50),
                        ACCOUNTTYPE varchar(50) not null, BALANCE decimal(8,2));
                        
ALTER TABLE ACCOUNT ALTER COLUMN BALANCE SET DEFAULT 0.0;
