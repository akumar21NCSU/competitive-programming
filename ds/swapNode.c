#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
	int value;
	struct Node* next;
}Node;

void push(Node** href, int val){

	Node* new_node = (Node*)malloc(sizeof(Node));
	new_node->value = val;
	new_node->next= *href;
	*href = new_node;
}

void print(Node* head){

	while(head!= NULL){
		printf("%d ->",head->value);
		head = head->next;
	}
	printf("\n");
}

void reverseItr(Node** href){

	Node* cur = *href;

	if(cur == NULL)
		return;

	Node* prev = NULL;
	Node* next = cur->next;

	while(next != NULL){
	
		cur->next = prev;
		prev = cur;
		cur = next;
		next = cur->next;

	}
	cur->next = prev;
	*href = cur;

}

Node* reverse(Node** href,Node* cur){

	if(*href == cur){
		Node* node = reverse(href, cur->next);
		node->next = cur;
		cur->next = NULL;
		return cur;
	}

	if(cur->next == NULL){
		*href = cur;
		return cur;
	}
	Node* node = reverse(href, cur->next);
	node->next = cur;
	return cur;
}

void reverse2(Node ** href){

	Node* first = NULL;
	Node* rest = NULL;

	if(*href == NULL){
		return;
	}

	first = * href;
	rest = first->next;

	if(rest == NULL)
		return;

	reverse2(&rest);
	first->next->next = first;

	first->next = NULL;

	*href = rest;

}

void swap(Node** headp, int a, int b){

	Node* head = *headp;
	Node* node1 = NULL;
	Node* node2= NULL;
	Node* prev1 = NULL;
	Node* prev2= NULL;
	Node* prev = NULL;
	Node* next1 = NULL;
	Node* next2 = NULL;

	while(node1 == NULL || node2 == NULL){
		if(head->value == a){
			node1 = head;
			prev1 = prev;
			next1 = head->next;
		}
		if(head->value == b){
			node2 = head;
			prev2 = prev;
			next2 = head->next;
		}
		
		prev = head;
		head= head->next;
	
	}

	if(prev1 != NULL){
		prev1->next = node2;
	}else{
		*headp = node2;
	}
	node2->next = next1;

	if(prev2 != NULL){
		prev2->next = node1;
	}else{
		*headp = node1;
	}
	node1->next = next2;
}

Node* merge(Node* head1, Node*head2){
	
	if(head1 == NULL)
		return head2;

	if(head2 == NULL)
		return head1;
	
	Node* head=NULL;
	if(head1->value < head2->value){
		 head = head1;
		 head->next = merge(head1->next, head2);
	}else{
		head = head2;
		head->next = merge(head1,head->next);
	}
	return head;


}


Node* mergeItr(Node* head1, Node* head2){

	Node dummy;
	Node* tail = NULL;
	tail = &dummy;

	while(1){
		if(head1 == NULL){
			tail->next = head2;
			break;
		}
		if(head2 == NULL){
			tail->next = head1;
			break;
		}

		if(head1->value <= head2->value){
			tail->next = head1;
			head1= head1->next;
		}else{
			tail->next = head2;
			head2= head2->next;
		}
		tail = tail->next;
	}
	
	return dummy.next;

}


Node* reversekUtil(Node* start, Node* end){

	//printf("Calling for %d and %d\n",start->value,end->value);	
	Node* cur = start;
	Node* prev = NULL;
	Node* next = NULL;
	Node* endNext = end->next;
	prev = endNext;

	while( cur != endNext){
	
		next = cur->next;	
		cur->next = prev;
		prev = cur;
		cur = next;		
		
	}
	//printf("Returning %d which is pointing to %d\n",end->value,end->next->value);
	return end;
}

void reverseK(Node ** href,int k){

	Node dummy;
	Node * tail = &dummy;
	Node* cur = *href;
	Node* start = cur;
	Node* end = NULL;
	while(cur != NULL){
		int i;
		start = cur;		
		for( i=1; i<k && cur->next!= NULL;i++){
			cur = cur->next;
		}
		end = cur;
		cur = cur->next;
		tail->next = reversekUtil(start,end);
		tail = start;
	}
	
	*href = dummy.next;
}


int main(int argc, char*argv[]){

	Node* head = NULL;

	push(&head,1);
	push(&head,3);
	push(&head,5);
	push(&head,7);
	//push(&head,9);
	//push(&head,111);
	reverse2(&head);
	//print(head);


	Node*head2 = NULL;
	push(&head2,2);
	push(&head2,4);
	push(&head2,6);
	push(&head2,8);
	push(&head2,10);
	push(&head2,12);
	push(&head2,14);
	push(&head2,16);
	reverse2(&head2);
	print(head2);
	//swap(&head,10,14);
	//reverseItr(&head);
	//reverse(&head,head);
	//reverse2(&head);
	//head = merge(head,head2);
	//head = mergeItr(head,head2);
	reverseK(&head2,3);
	/*int i;
	for(i=0;i<4;i++){
		printf("%d->",head2->value);
		head2 = head2->next;

	}*/
	print(head2);

	return 0;
}
