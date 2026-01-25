#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n;
vector<vector<int>> graph;
vector<vector<bool>> visited;
string bfs(int i, int i1);

void input(){
    cin >> n;

    graph.resize(n);
    visited.assign(n, vector<bool>(n, false));

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            int v;
            cin >> v;
            graph[i].push_back(v);

        }
    } // NxN 격자 만들기
}
string bfs(int startx,int starty){
    string bfs_result = "Hing";
    queue<pair<int,int>> q;
    q.push({startx,starty});
    visited[startx][starty] = true;
    // {1,0} , {0,1} 보물섬 문제처럼 배열 만들어서 돌려야될까?
    // move의 값 만큼 움직일 수 있음 우 나 하 방향으로만
    int dx[] = {1,0};
    int dy[] = {0,1};
    while(!q.empty()){
        pair<int,int> move = q.front(); //index 값의 묶음
        int coord_x = move.first; // index 좌표값이지 거리가 아님
        int coord_y = move.second;

        int jump = graph[coord_x][coord_y];// 젤리가 이동할 수 있는 거리 값

        q.pop();
        /*
          순서
          직선 점프 -> 점프한 좌표의  수(move)만큼 이동할 수 있나 없나 확인
        */
        if((coord_x + jump < n || coord_y + jump < n) && jump > 0){ // 일단 점프 거리가 좌표 길이보다는 작아야함
            for(int i = 0; i<2; i++){
                int new_x = coord_x + jump * dx[i]; // 이동
                int new_y = coord_y + jump * dy[i];
                if(new_x < n && new_y < n && !visited[new_x][new_y]){ // 좌표내에 있다면
                    q.push({new_x,new_y}); // 이동처리
                    visited[new_x][new_y] = true;
                    if(new_x == n-1 && new_y == n-1){
                        // {n,n}에 도착하면 승리니까
                        bfs_result = "HaruHaru";
                    }
                }
            }
        }

    }

    return bfs_result;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input(); // 입력

    cout << bfs(0,0) << '\n';
    return 0;
}