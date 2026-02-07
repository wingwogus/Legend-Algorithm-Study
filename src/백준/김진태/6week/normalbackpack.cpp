#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, k; //물품 수, 버틸 수 있는 무게
/*
vector<vector<int> > things; // 각 물건들의 무게와 가치
vector<int> weight;
vector<int> value;
vector<vector<int> > temp;

void input() {
    cin >> n >> k;
    weight.push_back(0); // 인덱스와 맞추기 위해
    value.push_back(0);
    for (int i = 0; i < n; i++) {
        int w, v;
        cin >> w >> v;

        weight.push_back(w);
        value.push_back(v);
    }
    temp.assign(n + 1, vector<int>(k + 1, 0)); // 물건 번호, 무게 담긴 건 최대 가치
}

int pack() {
    // 물건을 담는다, 안담는다를 생각
    for (int i = 1; i <= n; i++) {
        //물건의 무게와 K를 비교해서 담으면 순서에 따라 작기만 하면 배낭에 넣음
        // 최대 가치를 뽑을 수 없게 될 수도 있음
        for (int w = 1; w <= k; w++) {
            // 배낭이 1일때부터 탐색
            if (weight[i] <= w) { // w는 들 수 있는 무게
                // 담을 수 있다면
                // 담을지 안 담을지 결정
                // 담는다면 이전 가치에 현재 가치를 더할것이고 -> temp[i-1][w] + value[i-1];
                // 안담으면 이전 가치가 담은 현재 배낭의 가치가 될 것임 -> temp[i-1][w];
                // 저 둘중에 선택하는건 가치가 더 큰 것
                temp[i][w] = max(temp[i - 1][w], temp[i - 1][w - weight[i]] + value[i]);
                                // 이전 물건                      //특정 무게의 최선
            } else {
                // 담을 수 없다면 전에 가치를 현재에 저장
                temp[i][w] = temp[i - 1][w];
            }
        }
    }

    return temp[n][k];
}
*/
// 리펙토링
vector<int> wtemp;
vector<int> vtemp;
vector<int> dp; // 특정 무게에 따른 물건을 담았을 때 최대 가치
void input(){
    cin >> n >> k;

    wtemp.push_back(0); // 물건들 순서와 인덱스를 맞추기 위함
    vtemp.push_back(0); // 물건들 순서와 인덱스를 맞추기 위함
    for(int i=1; i<=n; i++){
        int w,v;
        cin >> w >> v;
        wtemp.push_back(w);
        vtemp.push_back(v);
    }
    dp.assign(k+1,0);
}
int pack(){
    for(int i=1; i<=n; i++){ // i = 물건 순서
        for(int w = k; w >= wtemp[i]; w--){
            if(wtemp[i] <= w){ // 특정 무게에 물건을 넣을 수 있다면
                dp[w] = max(dp[w], dp[w-wtemp[i]] + vtemp[i]);
                //이전 무게의 최댓값과 구한 특정 무게의 최대값을 비교
            }
        }
    }
    return dp[k];
}
int main() {
    cin.tie(NULL);

    input();
    cout << pack() << '\n';
    return 0;
}
