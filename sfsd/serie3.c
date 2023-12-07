#include <stdio.h>
#include <stdlib.h>
void TabTri(int *Tab, int size)
{
    int i, j, tmp;
    for (i = 0; i < size; i++)
    {
        for (j = i + 1; j < size; j++)
        {
            if (Tab[i] > Tab[j])
            {
                tmp = Tab[i];
                Tab[i] = Tab[j];
                Tab[j] = tmp;
            }
        }
    }
}

int RechercheDicho(int *Tab, int x, int size)
{
    int i = 0, j = size - 1, m;
    while (i <= j)
    {
        m = (i + j) / 2;
        if (Tab[m] == x)
        {
            return m + 1;
        }
        else if (Tab[m] < x)
        {
            i = m + 1;
        }
        else
        {
            j = m - 1;
        }
    }
    return -1;
}
void allOccurence(int *Tab, int x, int size)
{
    int i = 0, j = size - 1, m;
    while (i <= j)
    {
        m = (i + j) / 2;
        if (Tab[m] == x)
        {
            int k = m;
            while (Tab[k] == x)
            {
                printf("%d\n", k + 1);
                k++;
            }
            k = m - 1;
            while (Tab[k] == x)
            {
                printf("%d\n", k + 1);
                k--;
            }
            return;
        }
        else if (Tab[m] < x)
        {
            i = m + 1;
        }
        else
        {
            j = m - 1;
        }
    }
}

void exo1()
{
    int Tab[] = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    int size = sizeof(Tab) / sizeof(Tab[0]);
    TabTri(Tab, size);
    RechercheDicho(Tab, 5, size);
    allOccurence(Tab, 5, size);
}
typedef struct node *list;
typedef struct node
{
    int value;
    list next;
} node;

void add(int X, list *node)
{
    list tmp = (list)malloc(sizeof(node));
    tmp->value = X;
    tmp->next = *node;
    *node = tmp;
}

list createList(int X, list head)
{
    list tmp = NULL;

    while (head != NULL)
    {
        if (head->value % X == 0 )
        {
            add(head->value, &tmp);
        }
        head = head->next;
    }
    return tmp;
}

void printList(list head)
{
    while (head != NULL)
    {
        printf("%d   ", head->value);
        head = head->next;
    }

    printf("\n");
}

void OccurenceNumber(list head, int X)
{
    int count = 0;
    while (head != NULL)
    {
        if (head->value == X)
        {
            count++;
        }
        head = head->next;
    }
    printf("%d\n", count);
}

void deleteFirstOccurence(list *head, int X)
{
    list tmp = *head;
    list prev = NULL;
    if (tmp != NULL && tmp->value == X)
    {
        *head = tmp->next;
        free(tmp);
        return;
    }
    while (tmp != NULL && tmp->value != X)
    {
        prev = tmp;
        tmp = tmp->next;
    }
    if (tmp == NULL)
    {
        return;
    }
    prev->next = tmp->next;
    free(tmp);
}

list mergeSortedList(list head1, list head2)
{
    list node = NULL;

    while (head1 != NULL && head2 != NULL)
    {
        if (head1->value > head2->value)
        {
            add(head1->value, &node);
            head1 = head1->next;
        }
        else
        {
            add(head2->value, &node);
            head2 = head2->next;
        }
    }
    while (head1 != NULL)
    {
        add(head1->value, &node);
        head1 = head1->next;
    }

    while (head2 != NULL)
    {
        add(head2->value, &node);
        head2 = head2->next;
    }

    return node;
}
void exo2()
{
    list primaryList = NULL;
    add(1, &primaryList);
    add(2, &primaryList);
    add(3, &primaryList);
    add(4, &primaryList);
    add(5, &primaryList);
    add(6, &primaryList);
    add(7, &primaryList);
    add(8, &primaryList);
    add(9, &primaryList);
    add(10, &primaryList);

    list secondaryList = NULL;
    add(1, &secondaryList);
    add(5, &secondaryList);
    add(6, &secondaryList);
    add(12, &secondaryList);
    add(12, &secondaryList);
    add(24, &secondaryList);
    add(25, &secondaryList);
    add(26, &secondaryList);

    list multiList = createList(2, primaryList);

    printf("la liste des multiple de 2 :\n");
    printList(multiList);

    printf("dans la liste :\n");
    printList(secondaryList);
    printf("le nombre d'occurence de 12 est : ");
    OccurenceNumber(secondaryList, 12);

    printf("la liste avant la suppression :\n");
    printList(primaryList);
    deleteFirstOccurence(&primaryList, 5);
    printf("la liste apres la suppression :\n");
    printList(primaryList);

    list mergedList = mergeSortedList(primaryList, secondaryList);
    printf("la liste apres le fussion :\n");
    printList(mergedList);
}
int main()
{
    exo2();
    return 0;
}
