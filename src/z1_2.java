class ListElement {
    ListElement next;    // указатель на следующий элемент
    int data;            // данные
}

class List {
    private ListElement head;       // указатель на первый элемент
    private ListElement tail;       // указатель последний элемент
    void addFront(int data)           //добавить спереди
    {
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;              //инициализируем данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        }

        else {
            a.next = head;          //иначе новый элемент теперь ссылается на предыдущий первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }

    void addBack(int data) {          //добавление в конец списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;               //а в указатель на последний элемент записываем адрес нового элемента
        }
    }

    void printList()                //печать списка
    {
        ListElement t = head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существует
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
    }

    void delEl(int data)          //удаление элемента
    {
        if(head == null)        //если список пуст -
            return;             //ничего не делаем

        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        ListElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }

            t = t.next;                //иначе ищем дальше
        }
    }

    void replaceValue(int oldValue, int newValue) {  // ЗАДАНИЕ 1. метод для замены всех вхождений oldValue на newValue
        ListElement current = head;
        while (current != null) {
            if (current.data == oldValue) { // проверка, если данные текущего элемента равны oldValue
                current.data = newValue;  // замена oldValue на newValue
            }
            current = current.next; // переход к следующему элементу списка
        }
    }

    void removeConsecutiveDuplicates() { // ЗАДАНИЕ 2. в списке L из каждой группы подряд идущих равных элементов оставляет только один
        if (head == null || head == tail) {
            return; // список пуст или состоит из одного элемента, ничего не делаем
        }
        ListElement current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // если текущий элемент равен следующему, то удаляем следующий элемент
            } else {
                current = current.next; // иначе, переходим к следующему элементу
            }
        }
    }
}

public class z1_2 {
    public static void main(String[] args) {
        List ml = new List();

        ml.addBack(1);
        ml.addBack(2);
        ml.addBack(2);
        ml.addBack(3);
        ml.addFront(6);

        ml.printList();
        System.out.println();

        ml.replaceValue(2, 5);  // вызов метода, отвечающего за замену в списке L все вхождения E1 на Е2
        ml.removeConsecutiveDuplicates();  // вызов метода для удаления подряд идущих дубликатов

        ml.printList();
        System.out.println();
    }
}