%{ 
  int op = 0 ,i; 
  float n1, n2; 
%} 
  
digits  [0-9]+|([0-9]*)"."([0-9]+) 
add 	"+"
sub 	"-"
mul 	"*"
div 	"/"
line 	\n 
%% 

{digits} 	{start();}  
{add} 		{op=1;} 
{sub} 		{op=2;} 
{mul} 		{op=3;} 
{div} 		{op=4;} 
{line} 		{printf("\n Result: %f\n", n1);} 
  
%% 
start() { 
	if (op == 0)  
		n1 = atof(yytext);  
  
	else { 
		n2 = atof(yytext); 
  
		switch(op) { 
		case 1:
			n1 = n1 + n2; 
			break; 
  
		case 2:
			n1 = n1 - n2; 
			break; 
   
		case 3:
			n1 = n1 * n2; 
			break; 
   
		case 4:
			n1 = n1 / n2; 
			break; 
		} 
  
		op = 0; 
	} 
} 
  
main(int argv,char *argc[]) { 
	yylex(); 
} 
  
yywrap() { 
	return 1; 
} 