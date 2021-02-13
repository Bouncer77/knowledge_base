#!/bin/bash
psql postgresql://postgres:postgres@localhost/postgres << EOF
	   \set name_db=test_db2
	   create database :name_db;
       BEGIN;
       insert into t1 values (7, '777');
       select * from t1;
       ROLLBACK;
EOF