#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main(void) {
    int k;
    cin >> k;

    while (k > 0) {
        k--;
        string input;
        cin >> input;

        stack<char> st;
        for (int i = 0; i < input.length(); i++) {
            if (st.empty()) { //스택이 비어있다면 push
                st.push(input[i]);
            }
            else { //스택이 비어있지 않고
                if (st.top() == '(' && input[i] == ')') { //top이 여는 괄호면서 다음 인자가 닫는 괄호면
                    st.pop();
                }
                else { //그 외의 경우는 모두 push
                    st.push(input[i]);
                }
            }
        }
        if (st.empty()) {
            cout << "YES" << "\n";
        }
        else {
            cout << "NO" << "\n";
        }
    }
    return 0;
}