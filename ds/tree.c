#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
	int label;
	struct Node* lchild;
	struct Node* rchild;

}Node;

typedef struct Stack{
	Node* value;
	struct Stack* next;
}StackNode;

int isEmpty(StackNode* s){

	if(s == NULL)
		return 1;

	return 0;

}

void push(StackNode ** s,Node* val){

	StackNode* newStack = (StackNode*)malloc(sizeof(struct Stack));
	newStack->value = val;
	newStack->next = NULL;

	if(*s == NULL){		
		*s = newStack;
		return;
	}
	newStack->next = *s;
	*s = newStack;
}

Node* pop(StackNode** s){
	
	if(*s == NULL)
		return ;

	StackNode* temp = *s;
	*s = (*s)->next;
	Node* data = temp->value;
	free(temp);
	return data;
}

Node* createNode(int val){

	Node* newNode = (Node*)malloc(sizeof(struct Node));
	newNode->label = val;
	newNode->lchild= NULL;
	newNode->rchild= NULL;

	return newNode;
}

Node* addLChild(Node* parent, int value){
	
	Node* child = createNode(value);
	parent->lchild = child;
	return child;
}

Node* addRChild(Node* parent, int value){
	
	Node* child = createNode(value);
	parent->rchild = child;
	return child;
}

int height(Node* root){
	if(root == NULL)
		return 0;

	int lHeight = height(root->lchild)+1;
	int rHeight = height(root->rchild)+1;

	return (lHeight>rHeight)?lHeight:rHeight;

}

void printLevel(Node* root, int level){
	
	if(root == NULL)
		return;

	if(level == 1){
		printf("%d  ",root->label);
	}
	else{
		printLevel(root->lchild, level-1);
		printLevel(root->rchild,level-1);
	}
}

void levelTravel(Node* root){

	int i;
	int h = height(root);
	for(i=1;i<=h;i++){
		printLevel(root, i);
	}
}

int max(int a,int b, int c){
	
	return (a>b)?((a>c)?a:c):((b>c)?b:c);
	
}

int diameter(Node* root){

	if(root == NULL)
		return 0;

	int lheight = height(root->lchild);
	int rheight = height(root->rchild);
	int diam = lheight+rheight+1;

	int ldiameter = diameter(root->lchild);
	int rdiameter = diameter(root->rchild);

	return  max(diam, ldiameter, rdiameter);

}

int diameterOpt(Node* root, int * height){

	if(root == NULL){		
		*height = 0;
		return 0;
	}

	int ldiameter = diameterOpt(root->lchild,height);
	int lheight = *height;
	//printf("for root = %d lheight =%d\n",root->label,lheight);	
	int rdiameter = diameterOpt(root->rchild,height);
	int rheight = *height;
	//printf("for root = %d rheight =%d\n",root->label,rheight);

	*height = max(lheight,rheight,-1)+1;
	
	int diam = lheight+rheight+1;

	return  max(diam, ldiameter, rdiameter);

} 

void add(StackNode** s, Node* n){

	while(n!= NULL){
		push(s,n);
		n= n->lchild;
	}

}

void inOrderTraversal(Node* root){

	if(root == NULL)
		return ;
	StackNode* stack = NULL;	
	Node* cur = root;

	while(cur!= NULL){
		push(&stack,cur);
		cur= cur->lchild;
	}

	while(!isEmpty(stack)){
	
		Node* cur = pop(&stack);
		printf("%d - ",(cur)->label);

		add(&stack,cur->rchild);

	}	

}

int main(int argc, char* argv[]){

	
	Node* root = createNode(0);

	Node* child1 = addLChild(root,1);
	Node* child2 = addRChild(root,2);
	Node* child3 = addLChild(child1,3);
	Node* child4 = addRChild(child1,4);
	Node* child5 = addRChild(child2,5);

	Node* child6 = addLChild(child3,6);
	Node* child7 = addRChild(child3,7);
	Node* child8 = addRChild(child4,8);
	Node* child9 = addLChild(child7,9);
	Node* child10 = addLChild(child8,10);

	Node* child11 = addRChild(child8,11);
	Node* child12 = addLChild(child9,12);
	Node* child13 = addRChild(child9,13);
	Node* child14 = addRChild(child11,14);
	//Node* child15 = addRChild(child3,15);
	int h=0;
	//printf("Diameter is %d\n",diameterOpt(root,&h));
	inOrderTraversal(root);
	//levelTravel(root);
	//printf("Height of tree is %d\n",height(root));
	return 0;
}
