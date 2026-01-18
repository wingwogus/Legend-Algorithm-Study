#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n,m; //n -> 동기의 수라 총 사람의 숫자는 n+1임
int invite_num = 0; // 총 초대할 인원 수

int find_people_bfs(int start,vector<vector<int>>& graph_vec, vector<bool>& invited){
    int sum = 0; //
    vector<int> cnt(n+1, 3); // 상근이 기준 몇번 건너 사람인지

    cnt[start] = 0;

    queue<int> q;
    q.push(start);
    invited[start] = true;
    /* 인접 행렬 방식
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        for(int i=1; i<=n+1; i++){
            if(graph_vec[cur][i] && !invited[i]){
                // 현재 번호와 이어져있고(친구 사이) 초대하지 않았다면
                cnt[i] = cnt[cur] + 1; // 거리를 재고
                if (cnt[i] <= 2) {
                    sum++;
                    invited[i] = true;
                    if(cnt[i] == 2){
                        continue;
                    }
                    q.push(i);
                }
            }
        }
    }
    */
    // 인접 리스트 방식
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int next : graph_vec[cur]) {
            if(invited[next] == false && next != start) {
                cnt[next] = cnt[cur] + 1;
                sum++;
                invited[next] = true;
                if(cnt[next] == 2){
                    continue;
                }
                q.push(next);
            }
        }
    }
    return sum;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m ; // 동기 숫자와 간선의 개수

    /* 인접 행렬
    vector<vector<int>> graph_vec(n+1, vector<int>(n+1 , 0)); // 그래프 표시할 벡터
    vector<bool> invited(n+1);
    */

    // 인접 리스트
    vector<vector<int>> graph_vec(n+1);
    vector<bool> invited(n+1);

    fill(invited.begin(), invited.end(), false); // 방문 ㄴ

    for(int i=1; i <= m; i++){
        int a,b;
        cin >> a >> b;
        // {1,2} 와 {2,1}을 같다고 봄 -> 무방향 그래프
        // 인접행렬  : graph_vec[a][b] = graph_vec[b][a] = 1;
        // 인접 리스트
        graph_vec[a].push_back(b); // a와 b는 인접해 있다는 거임
        graph_vec[b].push_back(a); // 인접 행렬과 다른 식으로 생각해야됨.
    }

    // 시작 정점은 항상 상근이 번호인 1번임
    invite_num = find_people_bfs(1,graph_vec,invited);

    cout << invite_num << '\n';

    return 0;
}