#include<iostream>
#include<queue>
using namespace std;
const int MAX_SIZE = 100001; // 상수 선언
int n,m;
vector<int> dist(MAX_SIZE,0);
vector<bool> visitied(MAX_SIZE,false);
void input(){
    cin >> n >> m;

    visitied[n] = true; // 방문처리

}
void bfs(){
    int time = 0;
    bool is_meet = false;
    queue<pair<int,int>> q;
    q.push({n,time}); // 수빈이 위치와 시간

    while(!q.empty() && !is_meet){
        pair<int,int> cur = q.front();
        int pos = cur.first;
        int c_time = cur.second;
        q.pop();
        // 이동 : 좌우 한칸 or 현재 위치 x2 순간 이동
        int move_way[] = {pos-1,pos+1,pos*2};
        for(int move : move_way){
            int n_pos = move; // 이동
            int n_time = c_time+1; // 시간 증가
            if(n_pos<MAX_SIZE && n_pos>=0 && !visitied[n_pos]){ // 벡터 범위 내에 있고 방문하지 않았다면
                visitied[n_pos] = true; // 방문 처리
                dist[n_pos] = pos; // 이동 저장
                if(m == n_pos){ // 동생을 만났다면?
                    time = n_time; // 시간 저장
                    is_meet = true;
                    break; // for문 탈출
                }
                q.push({n_pos,n_time}); // 이동한 위치와 시간을 큐에 저장
            }
        }
    }
    cout << time << '\n';
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    bfs();
    return 0;
}