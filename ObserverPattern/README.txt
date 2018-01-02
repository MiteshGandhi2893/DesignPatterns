
## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt  -Darg3=output2.txt -Darg4=output3.txt

------------------------------------------------------------------------
