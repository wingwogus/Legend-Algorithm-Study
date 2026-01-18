#include <iostream>

using namespace std;

class Stack {
    string test_array;
    int top;

public:
    void push(char c);

    void pop();

    bool is_full();

    bool is_empty();

    Stack();
};

Stack::Stack() : top(-1) {
    test_array.resize(51); // 최대 범위
} // 생성자
bool Stack::is_full() {
    if (top == test_array.size() - 1) {
        return true; // 꽉참
    }
    return false; // 안참
}

bool Stack::is_empty() {
    if (top == -1) {
        return true; // 빔
    }
    return false; // 안빔
}

void Stack::push(char c) {
    if (is_full()) {
        return;
    }
    test_array[++top] = c;
}

void Stack::pop() {
    if (is_empty()) {
        return;
    }
    test_array[top--] = '\0'; // Pop한 값을 배열에 두지 않기 -> null로 변경
}

void Is_Vps(Stack s, string test);

int main_parentheses() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    int testcase;
    string test;

    cin >> testcase; // 시험할 괄호 열 개숫

    for (int i = 0; i < testcase; i++) {
        cin >> test; // 괄호
        Stack s;
        Is_Vps(s, test);
    }
}

void Is_Vps(Stack s, string test) {
    for (int i = 0; i < test.size(); i++) {
        if (test[i] == '(') {
            s.push(test[i]);
        } else if (test[i] == ')') {
            if (s.is_empty()) {
                cout << "NO" << '\n'; // )일 때 배열이 비었다는건 (가 없다는 뜻이니
                return; // 함수종료
            }
            s.pop(); // ( 였던게 \0 null
        }
    }
    if (s.is_empty()) {
        cout << "YES" << '\n';
    } else {
        cout << "NO" << '\n';
    }
}
