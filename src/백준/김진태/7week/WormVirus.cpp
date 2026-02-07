#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int n,c;
vector<vector<int>> v;
vector<bool> vistied;
void input() {
    cin >> n;
    cin >> c;
    v.assign(n+1, vector<int>(n+1,0));
    vistied.assign(n+1, false);
    for (int i = 0; i < c; i++) {
        int a,b; // 연결되는 정점 번호
        cin >> a >> b;
        v[a][b] = 1;
        v[b][a] = 1; // 간선 연결
        // 무방향 그래프
    }

}
void bfs(int s) {
    int cnt = 0;
    queue<int> q;
    q.push(s);
    vistied[s] = true; // 방문처리
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int i = 1; i <= n; i++) {
            if (v[cur][i] == 1 && !vistied[i]) {
                q.push(i);
                vistied[i] = true;
                cnt++;
            }
        }
    }
    cout << cnt << '\n';
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    bfs(1);
    return 0;
}