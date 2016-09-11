#include<stdio.h>
#include<stdlib.h>

typedef struct Stack{
	
	int capacity;
	int top;
	int * arr;
}Stack;

Stack* createStack(int cap){

	Stack* newStack = (Stack*)malloc(sizeof(Stack));
	newStack->capacity = cap;
	newStack->top = -1;
	int* newArr = (int*)malloc(sizeof(int)*cap);
	newStack->arr = newArr;
	return newStack;
}

int isFull(Stack* s){
	if(s->top == s->capacity)
		return 1;

	return 0;
}

int isEmpty(Stack* s){
	if(s->top == -1)
		return 1;
	return 0;
}

void push(Stack* s, int value){
	if(isFull(s))
		return;

	s->top = s->top +1;
	s->arr[(s->top)] = value;	
}

int pop(Stack * s){
	if(isEmpty(s))
		return;

	int temp= s->arr[(s->top)];
	s->top = s->top -1;	
	return temp;
}

int peek(Stack* s){
	if(isEmpty(s))
		return;
	return s->arr[s->top];
}

void printStack(Stack* s){
	if(isEmpty(s))
		return;

	printf("%d\n",pop(s));
	printStack(s);	

}

void insert(Stack* s, int temp){
	//printf("Trying to insert %d\n",temp);
	if(isEmpty(s)){
		push(s,temp);
		//printf("Inserting into empty %d\n",temp);
		return;
	}
	if(temp >= (s)->arr[(s)->top]){
		push(s,temp);
		//printf("Inserting over top %d\n",temp);
	}else{
		int x = pop(s);
		insert(s,temp);
		push(s,x);
	}

}

void sortStack(Stack *s){
	
	if(isEmpty(s))
		return;

	int temp = pop(s);
	sortStack(s);
	//printf("order = %d\n",temp);
	insert(s,temp);
}

int main(int argc, char* argv[]){

	Stack* s = createStack(6);
	push(s,10);
	push(s,3);	
	push(s,7);
	push(s,1);
	push(s,0);
	//printStack(s);
	sortStack(s);
	printStack(s);
	return 0;
}
