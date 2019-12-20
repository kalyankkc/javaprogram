echo "Enter two numer"
read a
read b
echo "Enter 1 for addition"
echo "Enter 2 for substraction"
echo "Enter 3 for multipication"
echo "Enter 4 for division"
read n
if [ $n -eq 1 ]
then
echo `expr $a + $b`
elif [ $n -eq 2 ]
then
echo `expr $a - $b`
elif [ $n -eq 3 ]
then
echo `expr $a \* $b`
elif [ $n -eq 4 ]
then
echo `expr $a / $b`
fi
#my calculator
#updated fle

