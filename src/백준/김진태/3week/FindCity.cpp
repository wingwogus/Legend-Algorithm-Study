#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> bfs(int start, vector<vector<int> > &graph_veac, vector<bool> visited);

vector<int> cal_dis(vector<int> &dist);

int n, m, k, x;
// 방향 그래프 문제임
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 도시 개수, 도로 개수, 최단거리, 출발 도시(노드)
    cin >> n >> m >> k >> x;

    // 그래프 // 0번은 사용하지 않을 거임
    // 인접 리스트 -> 메모리 초과 방지
    vector<vector<int> > graph_vec(n + 1);

    vector<bool> visited(n + 1, false);


    for (int i = 0; i < m; i++) {
        int a, b; // 시작, 방향
        cin >> a >> b;
        graph_vec[a].push_back(b);
    }
    vector<int> ans = bfs(x, graph_vec, visited);
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
        if (i == ans.size() - 1) {
            cout << '\n';
        }
    }
}

vector<int> bfs(int start, vector<vector<int> > &graph_vec, vector<bool> visited) {
    queue<int> q;
    q.push(start); // 시작 정점

    vector<int> dist(n + 1, -1); // 시작 정점 기준 거리 1차원 벡터

    dist[start] = 0; // 시작 정점 시작
    visited[start] = true; // 방문 처리
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int i = 1; i <= n; i++) {
            if (graph_vec[cur][i] && !visited[i]) {
                q.push(i);
                visited[i] = true;
                dist[i] = dist[cur] + 1;
            }
        }
    }
    vector<int> ans = cal_dis(dist);
    return ans;
}

vector<int> cal_dis(vector<int> &dist) {
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
        if (dist[i] == k) {
            ans.push_back(i);
        }
    }
    if (ans.empty()) {
        ans.push_back(-1);
    }
    return ans;
}
