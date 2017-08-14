# Navigator

## About
NAVIGATOR is a data service that prepares the content for travel agencies, ready for exploration in EWNS (East-West-North-South) direction and hence allows them to render content to the end user based on their desire to travel. 

The Travel agency’s mobile application interface will use the data stream generated by this project to ensure reliable and updated content delivery at all times. Suppose the end user is at point x on the map, the JSON output of this data service contains geocoded data of all the cities, within the radius of 25kms of x, in all 4 directions. This is how it'll help the traveller to navigate. 

The geocoded input data was extracted from Wikipedia because of its reliability, owing to its crowdsourcing methodology; link is in the SRS document, 'Navigator.pdf'. The solution was developed using the MapReduce paradigm of hadoop. The development was carried out on Cloudera Apache Hadoop Framework using Eclipse Version 4.4.2 and Apache HIVE. The output generated is in JSON format.

## Requirements 
1. If you have never worked with hadoop, you need to setup a single node hadoop cluster on your system. Your system can either be a standalone system as well as a system existing as a node in a cluster. You can get all the installation information from this site:
http://doctuts.readthedocs.io/en/latest/hadoop.html .

2. You need to install Apache HIVE on your Linux system. The information about this is present on this link;
https://www.edureka.co/blog/apache-hive-installation-on-ubuntu

## Usage
All the information about how to do generate the output JSON file is given in the 'Commands.txt' file. Also the compressed version of input data is present as the 'geo-coordinates_en.rar' file. After etracting data from this, follow the 'Commands.txt' file.
