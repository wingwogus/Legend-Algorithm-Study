#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int bfs(int ns,int nm, vector<vector<char>>& graph_vec, vector<vector<bool>>& visited);
int cal_dis(vector<vector<int>>& dist); // 인스턴스(별명) 넘기기
int n,m;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> m ;

    vector<vector<char> > graph_vec(n, vector<char>(m));
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    int result = 0;

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> graph_vec[i][j] ;
        }
    } // 그래프 입력

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(graph_vec[i][j] == 'L') { // L일 경우에만
                visited[i][j] = true;
                int dis = bfs(i,j,graph_vec,visited);

                for(int k=0;k<n;k++) {// 2차원 벡터 채우는 방법
                    fill(visited[k].begin(), visited[k].end(), 0); // 초기화
                } // fill(visited.begin(), visited.end(), 0); -> 1차원 벡터 채우는 방법
                result = max(result,dis);
            }
        }
    }
    cout << result << '\n';
}
int bfs(int ns, int ms,vector<vector<char> >& graph_vec,vector<vector<bool>>& visited) {
    queue<pair<int,int>> q; // 2개의 정수 하나로 묶어줌 -> pair
    q.push({ns,ms}); // 시작 정점 (기준)

    vector<vector<int>> dist(n,vector<int>(m,-1)); // 거리만 따질 그래프
    dist[ns][ms] = 0; // 시작노드 시작

    // 상하좌우 이동
    int dx[] = { -1, 1 , 0, 0}; // 배열에 저장함으로써 코드를 줄임
    int dy[] = { 0, 0, -1, 1};

    while(!q.empty()) {
        // 현재 큐 맨 앞 좌표
        int n_coord = q.front().first; // 상하
        int m_coord = q.front().second; // 좌우
        q.pop(); // 제거
        for(int i=0;i<4;i++) { // 상하좌우 순서
		        // 상하좌우 옮기면서 L인지를 찾을 수 있음.
		        // 간선 유무라고 생각해도 될듯함.
            int next_n_coord = n_coord + dx[i];
            int next_m_coord = m_coord + dy[i];
            if (next_n_coord >= 0 && next_m_coord >=0 && next_n_coord < n && next_m_coord < m) {
                if (graph_vec[next_n_coord][next_m_coord] == 'L' && !visited[next_n_coord][next_m_coord]) {
                    q.push({next_n_coord, next_m_coord});
                    visited[next_n_coord][next_m_coord] = true;
                    dist[next_n_coord][next_m_coord] = dist[n_coord][m_coord] + 1;
                    // 각 배열의 원소가 시작 정점을 기준으로 거리를 가지게됨
                }
            }
        }
    }
    return cal_dis(dist); // 최대값구하기
}
int cal_dis(vector<vector<int>>& dist) {
    int result = 0;

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
           if(result <= dist[i][j]) {
               result = dist[i][j];
           }
        }
    }
    return result;
}
