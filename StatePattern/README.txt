## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=4

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date:10/19/2017]
 
-----------------------------------------------------------------------
I have used the following logic for the assignment


Day:1;TOD:6:00;Airline:AirIndia;Item:Chai
Day:1;TOD:7:00;Airline:AirChina;Item:Gun
Day:2;TOD:9:08;Airline:Delta;Item:Knife
Day:2;TOD:01:50;Airline:AirChina;Item:Knife
Day:2;TOD:11:30;Airline:AirIndia;Gun
Day:3;TOD:01:20;Airline:Emirates;Item:Hairpin

So on the base of the above taken input example I have used the below logic…


The SecurityFactors. for  traveller two will be based upon traveller 1 so the formula for determining the state 
before the check for traveller two is:
Average Traffic Per Day = Total number of travellers ÷ Total number of days = 1/1
Average Prohibited Items Per Day = 
Total number of prohibited items ÷ Total number of days = 0/1
STATE = LOW_RISK
AS (0 ≤ average traffic per day < 4 OR 0 ≤ average prohibited items per day < 1)


The SecurityFactors. for  traveller six will be based upon travellers before six so the formula for determining the state 
before the check for traveller two is done is
Average Traffic Per Day = Total number of travellers ÷ Total number of days = 5/2 = 2.5
Average Prohibited Items Per Day = 
Total number of prohibited items ÷ Total number of days = 4/2 = 2
STATE = HIGH_RISK 

AS (average traffic per day ≥ 8 OR average prohibited items per day ≥ 2)
-----------------------------------------------------------------------
Data Structure

I have used HashMap for storing all the details of customers one by one
