# Sentiment Analysis Tool

This sentiment analysis tool is meant to ingest data (a file of new articles), clean the data so that only political news article remain, and then output a sentiment score for a keyword given by the user.

# Files

Clean.java, CleanMapper.java, and CleanReducer.java use MapReduce to filter the dataset (in this case and .csv file) so that only political new articles remain in the output. The Reducer in this case does not do anything. 

CountRec.java, CountRecsMapper.java, and CountRecsReducer.java use MapReduce to count the number of records in the dataset. In this case, the number of political news articles. 

DataAnalytics.scala contains the scala commands to be used in the Spark shell. 

bbc.csv contains all 2006 BBC news articles 

