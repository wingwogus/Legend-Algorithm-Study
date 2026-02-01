#include <iostream>
#include <vector>
using namespace std;
int n;
vector<int> wine;
vector<vector<int>> temp; // 계산 저장용
void input(){
    cin >> n; // 포도잔의 갯수

    temp.assign(n,vector<int>(3, 0));
    // 현재위치, (연속 몇번째로 먹고 있는지)
    // 0 -> 안 마심 , 1 -> 연속 1번째, 2->연속 2번째
    for(int i = 0; i<n; i++){
        int amount;
        cin >> amount;
        wine.push_back(amount);
    }
}
// 현재 잔을 안 마셨을 때 최대 양
int b_max(int cur){
    int cur_max = 0;
    for(int i=0; i<3; i++){
        if(cur_max <= temp[cur-1][i]){
            cur_max = temp[cur-1][i];
        }
    }
    return cur_max;
}
int cal_max(){
    int row_max,total_max;
    row_max = total_max = 0 ;
    for(int i = 0; i<3; i++){
        for(int j=0; j<n; j++){
            if(row_max <= temp[j][i]){
                row_max = temp[j][i];
            }
        }
        if(total_max<= row_max){
            total_max = row_max;
        }
    }
    return total_max;
}
// temp에는 그때까지 먹은 와인의 최댓값이 들어가면 되지 않을까
// 최대 연속 2번까지
int drink(){
    int max_dirnk = 0; // 최대한으로 먹은 와인의 양

    temp[0][0] = 0; // 첫번째 잔을 안 마신다 // 없애도 됨 위에서 초기화되어있음
    temp[0][1] = wine[0]; // 마신다
    // 2번째 잔부터 마실지 넘길 지 결정
    for(int i=1; i<n; i++){
        if(i == 1){ // 2번째 자리 일때만 -> 전전 잔이 없으니까
            temp[i][0] = b_max(i); // 안마신다
            temp[i][1] = wine[i]; // 연속 1번째
            temp[i][2] = temp[i-1][1] + wine[i]; // 연속 두번째
        }
        else{
            temp[i][0] = b_max(i); // 안마신다 -> 전잔에서 가장 큰거
            // 연속 1번째 마신다 -> 이전에 안먹은 상태 + 현재잔
            temp[i][1] = temp[i-1][0] + wine[i];
            // 연속 2번째 마신다 -> 이전의 연속 1번째 마신다 + 현재 잔 양
            temp[i][2] = temp[i-1][1] + wine[i];
        }
    }
    max_dirnk = cal_max();
    return max_dirnk;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    cout << drink() << '\n';
    return 0;
}