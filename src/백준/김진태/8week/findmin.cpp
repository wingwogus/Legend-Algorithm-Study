#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

int n, m;
int start, des;
vector<vector<pair<int, int> > > city;
vector<int> dist; // 시작 정점과의 거리

void input() {
    cin >> n;
    cin >> m;
    city.resize(n + 1);
    for (int i = 0; i < m; i++) {
        int s, d, c; // 출발 번호, 도착번호, 비용(가중치)

        cin >> s >> d >> c;
        city[s].push_back({d, c}); // <연결된 노드, 거리> 순서
    }
    cin >> start >> des;
}
void dijkstra(int s){
    dist.assign(n+1,INT_MAX);
    priority_queue<pair<int,int>> pq; // 우선 순위 큐
    dist[s] = 0; // 시작 노드는 최소거리가 0이니.

    pq.push({0,s}); // 첫번째 인자를 기준으로 내림차순

    while(!pq.empty()){
        int cur_dis = -pq.top().first;
        int cur_node = pq.top().second;
        pq.pop();
        if (cur_dis > dist[cur_node]) continue;
        for(int i=0; i<city[cur_node].size(); i++){
            int n_node = city[cur_node][i].first; // 인접 정점 번호
            int n_dis = cur_dis + city[cur_node][i].second; // 인접 정점까지 거리

            if(n_dis < dist[n_node]){
                dist[n_node] = n_dis;
                pq.push({-n_dis,n_node});
            }
        }
    }
    cout << dist[des];
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    dijkstra(start);

    return 0;
}
