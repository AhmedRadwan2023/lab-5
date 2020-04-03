package eg.edu.alexu.csd.datastructure.stack;


public class App implements IExpressionEvaluator {
	
   private int piro(char c) {
	   /* 
	    * this function gives (+,-) 1 and (*,/) 2 
	    * and this akkows me to get their pirority
	    * @parameters : character c
	    * @returns : integer d
	    */
	   if (c=='+' || c== '-') {
		   return 1;
	   }
	   else if (c=='*' || c== '/'){
		   return 2;
	   }
	   else {return 0;}
   }
   
   
   private String trim (String s) {
	   /* this function removes any spaces
	    * in the string taken from the user
	    *@ parameters:  string s
	    *@ returns:  string d
	    */
	   String d="";
	   for(int i=0;i<s.length();i++) {
		   if(s.charAt(i)==' ') {  
		   }
		   else {d+=s.charAt(i);}
	   }
	   return d;
   
   }
   
   
   
   private String dummyZero(String s) {
	   /* this function generate the dummy zero
	    * when a negative number is found it converts it to (0-number)
	    * and when a '(' is found it multiply it by -1 as (0-1)*(..)
	    *@ parameters : string s
	    *@ returns : string d
	    */
	   
	   s=trim(s); 	   String d=""; 
	   for(int j=0;j<s.length();j++) {   
	   if (s.charAt(j)=='-') {
		  if(j==0 || piro(s.charAt(j-1))==1 || piro(s.charAt(j-1))==2) {
			  if(s.charAt(j+1)=='(') {
				  d+="(0-1)*";
				  j++;
			  }
			  else {
			  d+="(0-"+s.charAt(j+1); j++;  
			   for(int i=j+1;i<s.length();i++) {
				   if(!Character.isDigit(s.charAt(i))) {
					break;
				   }
				   d+=s.charAt(i); j++;
		   }      d+=')';
				  continue;
			  }
		  }
	   }
	   d+=s.charAt(j);
	   }
	return d;   
   }
   
   
   
   public String infixToPostfix(String expression) {
	   /* this function takes the expression performs the dummy zero function 
	    * and make a new stack when an operator found it pushes it in 
	    * and goes to the next character if it's a digit it makes a new string and put the digit
	    * at the end it pop all the operator from the stack and puts them
	    * considering the priorities of the operations 
	    * @parameters : string expression
	    * @ returns : string post
	    */
	   expression=dummyZero(expression);   
	   String post = ""; 	   stack s = new stack();
	   	     
	   for (int i =0 ; i<expression.length();i++) {
		   char c = expression.charAt(i);
		   if(c=='-') {  
			  if(i==0) {
				  post+="0 "+expression.charAt(i+1)+" - ";
			  }
			  else {
				  if(piro(expression.charAt(i-1))>=1) {
					  post+="0 "+expression.charAt(i+1)+" - ";
					  
				  }
			  }
		   }
		   if (Character.isDigit(c) || Character.isLetter(c)) {
			   post+=c;
			   while((i+1)<expression.length() ){
				 if(Character.isDigit(expression.charAt(i+1)) || Character.isLetter(expression.charAt(i+1))){
					 
				 post+=expression.charAt(i+1);
				 i++;
				 }
				 else {post+=' ';break;}
			   }
			
		   }
		   else if (c=='(') {s.push('(');}
		   else if (c==')') {
			   while((char)s.peek()!= '(') {
				   post+=s.pop()+" ";
			   }
			   s.pop();
		   }

		   else if(s.isEmpty()==true) {
			   s.push(c);
		   }
		   else if(s.isEmpty()!= true) {
			   if(piro(c)> piro((char) s.peek())) {
				   s.push(c);
			   }
			   else {
				   while( ! s.isEmpty() && !(piro(c)> piro((char) s.peek())) ) {
					   post+=s.pop()+" ";
					   
				   }
				   s.push(c);
			   }
			   
		   }
		
		   
	   }
	   while(!s.isEmpty()) {
	   post+=" "+s.pop();
	   }
	   return post;
   }
   
   public int evaluate(String expression) {
	   /*this function makes a stack puts every number in the string in it
	    * and when an operator is found it pop the last two number 
	    * ,performs the operation on them and then push the result on the stack again
	    * @ parameters : string expression
	    * @ return : integer (top of the stack)
	    */
	   String post = infixToPostfix(expression);
	   post=post.trim();
	   stack d=new stack();
	   for(int i=0; i<post.length();i++) {
		   char c = post.charAt(i);
		   if(Character.isLetter(c)) {
			throw new RuntimeException(); 
		   }
		   else {
			   if(c==' ') {}
		       else if(Character.isDigit(c)) {
				   String temp =""+c;
				   while(post.charAt(i+1)!=' ') {
					    temp +=post.charAt(i+1); i++;
				   }
				   
				   d.push(Integer.parseInt(String.valueOf(temp)));
			   
			   }
			   else { 
				   int n2=(int) d.pop();
				   int n1=(int) d.pop();
				   switch (c) {
				   
				   case '+':d.push(n1+n2); break;
				   case '-':d.push(n1-n2); break;
				   case '*':d.push(n1*n2); break;
				   case '/':d.push(n1/n2); break;
				   
				   }
			   }
			   
		   }
	   }
	   return (int)d.pop();
   }
   
}