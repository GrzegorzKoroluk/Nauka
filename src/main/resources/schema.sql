-----------------------------------------------------------------------------

DROP ALL OBJECTS;

-----------------------------------------------------------------------------

CREATE TABLE CELESTIAL_BODIES (
ID NUMBER(28) PRIMARY KEY NOT NULL,
NAME VARCHAR2(50) NULL,
DIAMETER_KM NUMBER(28) NULL,
DISTANCE_FROM_THE_SUN_KM NUMBER(28) NULL,
CREATED_AT TIMESTAMP,
UPDATED_AT TIMESTAMP
);
