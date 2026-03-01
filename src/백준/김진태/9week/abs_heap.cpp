#include <iostream>
#include <queue>
using namespace std;
int n;
priority_queue<pair<int,int>> p_q; // 들어온 값을 담을 배열
void erase_absolute_min(){
    // 배열이 비어있는 상태면 0출력
    if(p_q.empty()){
        cout << 0 << '\n';
        return ;
    }
    // 배열이 비어있지 않은 경우
    cout << -(p_q.top().second)<< '\n';
    p_q.pop(); // 삭제

}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for(int i=0; i<n; i++){
        int v;
        cin >> v;
        if(v!=0){ // 입력값이 0이 아니면
            p_q.push({-(abs(v)),-v}); // 절댓값,원래 값 저장

        }else{  // 0이면 검사 후 출력
            erase_absolute_min();
        }

    }
    return 0;
}