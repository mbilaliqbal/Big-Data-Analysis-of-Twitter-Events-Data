#!/bin/bash
clear



gunzip data.sql\(1\).gz


mysql -utraining -ptraining <sqlprep1.sql


echo "Loading data. This may take a while."
mysql -u training -ptraining <data.sql\(1\) bigdata

mysql -u training -ptraining <sqlprep2.sql



echo "Importing into Hive/Impala"
sqoop import-all-tables --connect jdbc:mysql://localhost/bigdata --username training --password training --hive-import

echo "Importing to HDFS"
sqoop import-all-tables --connect jdbc:mysql://localhost/bigdata --username training --password  training --warehouse-dir /user/training/bigdata 


echo "Running Data Prep"
impala-shell -f dataprep.sql

echo "Runnign Q1 Solution"
impala-shell -f q1.sql >q1.txt

echo "Running Q2 Solution"
impala-shell -f q2.sql >q2.txt

echo "Running Q2 Extension"
impala-shell -f q2extension.sql >q2extension.txt

echo "Running Q3 Solution"
impala-shell -f q3.sql >q3.txt

echo "Running Q4 Solution"
impala-shell -f q4.sql >q4.txt

echo "Running Q4 Alternative"
impala-shell -f q4alternative.sql >q4alternative.txt

echo "Running Q5 Solution"
impala-shell -f q5.sql >q5.txt

echo "Running Q6 Solution"
impala-shell -f q6.sql >q6.txt

echo "Fetched the results and saved to local directory"


echo "Now running the Scala implementation"


spark-submit --class Q1 Q1-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6
spark-submit --class Q2 Q2-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6
spark-submit --class Q3 Q3-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6
spark-submit --class Q4 Q4-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6
spark-submit --class Q5 Q5-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6
spark-submit --class Q6 Q6-1.0.jar --driver-memory 8G --executor-memory 8G --executor-cores 6



hadoop fs -copyToLocal /user/training/q1.txt ~/scalaans

hadoop fs -copyToLocal /user/training/q2.txt ~/scalaans

hadoop fs -copyToLocal /user/training/q3.txt ~/scalaans

hadoop fs -copyToLocal /user/training/q4.txt ~/scalaans

hadoop fs -copyToLocal /user/training/q5.txt ~/scalaans

hadoop fs -copyToLocal /user/training/q6.txt ~/scalaans

echo "The Scala answers have been saved to /home/training/scalaans"
