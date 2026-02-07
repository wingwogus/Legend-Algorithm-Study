#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n,m;
vector<vector<int>> lab;
vector<vector<bool>> vistied;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int max_safe = 0; // 안전구역의 최대값
void input(){
    cin >> n >> m;

    for(int i=0; i<n; i++){
        vector<int> temp;
        for(int j=0; j<m; j++){
            int lab_room;

            cin >> lab_room;
            temp.push_back(lab_room);
        }
        lab.push_back(temp);
    } // 맵 입력
  vistied.assign(n,vector<bool>(m,false));
}
bool check_b(int w, int h,vector<vector<int>>& lab_temp){
    if(w<n&& h<m && w>=0 && h>=0){
        if(lab_temp[w][h] == 0){// 빈칸이면
            return true;
        }
    }
    return false;
}
void bfs(pair<int,int> start,vector<vector<int>>& lab_temp){ // 바이러스 증식
  queue<pair<int,int>> q;
  q.push(start); // start -> 좌표중 가장 가까운 바이러스 좌표
  int x = start.first;
  int y = start.second;
  vistied[x][y] = true; // 방문처리

  for(int i=0; i<n; i++){ // 처음에 다 찾아서 넣기
      for(int j=0; j<m; j++){
        if(lab_temp[i][j]==2 && !vistied[i][j]){
          q.push({i,j}); // 바이러스고 방문 안한 바이러스 칸
          vistied[i][j] = true;
        }
      }
  }
  // 현재 큐는 전체를 돌아서 2인 것들이 전부 저장되어있을 거임
  // 그 후에 연결되지 않은 것들도 찾을 수 있음.
  while(!q.empty()){
    pair<int,int> cur = q.front();
    int w = cur.first;
    int h = cur.second;
    q.pop();

    for(int i=0; i<4; i++){
      int n_w = w + dx[i];// 좌표 이동
      int n_h = h + dy[i];
      if(check_b(n_w,n_h,lab_temp) && !vistied[n_w][n_h]){
        q.push({n_w,n_h}); // 바이러스고 방문 안한 바이러스 칸
        vistied[n_w][n_h] = true;
        lab_temp[n_w][n_h] = 2; // 증식
      }
    }
  }
}
int cnt_safe(vector<vector<int>>& lab_temp){ // 다 끝난 뒤에 안전구역 갯수 세기
  int c = 0;
  for(int i=0; i<n; i++){
    for(int j= 0; j<m; j++){
      if(lab_temp[i][j] == 0){
        c++;
      }
    }
  }
  return c;
}
pair<int,int> first_b(){ // 가장 첫번째 바이러스칸 찾기
  int fx = 0,fy = 0;
  for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(lab[i][j]==2){
          fx = i;
          fy = j;
          return {fx,fy};
        }
      }
    }
}
void wall_dfs(int cnt){
  if(cnt == 3){ // 벽이 3개 전부 세워졌다면 -> basecase겠지?
    vector<vector<int>> lab_temp(lab); // 복사본
    bfs(first_b(),lab_temp); // 바이러스 위치 찾아서 증식해보고
    int safe = cnt_safe(lab_temp);
    if(max_safe<safe){
      max_safe = safe;
    } // 안전구역 몇개인지 세기
    vistied.assign(n,vector<bool>(m,false)); // 초기화
    return;
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(lab[i][j] == 0){
        lab[i][j]=1; // 벽세우고
        wall_dfs(cnt+1); // 재귀 넘기고
        lab[i][j]=0; // 초기화
      }
    }
  }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    // 벽을 세우는 걸 dfs로? 벽은 3개를 세워야함 무조건
    // 세울 벽을 찾아야되지 않을까 0인곳 찾아서 하나씩 다
    // 세우고 증식 시키고 확인하고 다음

    // 벽 세우고 bfs로 확인
    wall_dfs(0);

    cout << max_safe << '\n';
    return 0;
}