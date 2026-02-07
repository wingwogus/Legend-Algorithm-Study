#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int t,n;

void greedy(vector<pair<int,int>>& grade){
    // 넘어온 grade는 1,2,3,4,5 서류 순으로 정렬이 된 상태
    // 서류 1등은 안 건들여도 되니까 grade의 맨 마지막 n-1 or grade.size() - 1 부터 찾으면 되지않나?
    // 서류 2등은 1등보다만 면접 순위가 높으면 되고, 3등 1,2등 보다 4등은 1,2,3등
    // 그니까 자신 앞선 사람들 보다만 면접 순위가 높으면 탈락하지 않는다 아님?
    int cnt = n; // 뽑힐 신입 사원 수
    int bb = grade[0].second; ; // 앞선 사람들중 면접 최고 순위
    for(int i=1; i<n; i++){ // i는 자신(비교할 사람)

        if(bb > grade[i].second){ // 자신이 앞선 사람들보다 높은 순위면
            bb = grade[i].second; // 최고 순위 갱신
            continue;
        }
        else{ // 낮은 순위면
            cnt--;
        }
    }
    cout << cnt << '\n';
}
void input(){
    cin >> t;

    for(int i=0; i<t; i++){
        cin >> n;
        vector<pair<int,int>> grade(n);
        for (int j = 0; j < n; j++) {
            cin >> grade[j].first >> grade[j].second;
        }
        sort(grade.begin(),grade.end()); // first 기준 정렬
        greedy(grade);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}