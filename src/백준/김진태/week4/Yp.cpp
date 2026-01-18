#include <iostream>

using namespace std;

int sx,sy;
int ex,ey; // 1. 시작점 , 2. 도착점

// 시작 좌표와 도착 좌표가 원밖인지 안인지 구별
bool is_in_start(int cx, int cy, int r){
    int x_ = (cx - sx) * (cx - sx);
    int y_ = (cy - sy) * (cy - sy);
    int r_ = r*r;

    return x_+y_ < r_;
}
bool is_in_end(int cx, int cy, int r){
    int x_ = (cx - ex) * (cx - ex);
    int y_ = (cy - ey) * (cy - ey);
    int r_ = r*r;

    return x_+y_ < r_;
}
void Is_faced(int cx, int cy, int r, int &cnt){
    // 둘다 같은 원 안에 있거나 둘다 밖에 있으면 cnt는 증가하지 않음
    // (cx - x1)^2 + (cy - y1)^2 < r^2 면 증가

    // XOR
    if(is_in_start(cx,cy,r) != is_in_end(cx,cy,r)){
        cnt++;
    }
}
int main(){
    cin.tie(NULL);

    int testcase;
    cin >> testcase;

    for(int k=0; k < testcase; k++){
        cin >> sx >> sy >> ex >> ey; // 1. 시작점 , 2. 도착점

        int n; // 행성계 개수
        cin >> n;
        int cnt = 0; // 집입/이탈 횟수
        for(int i=0; i<n; i++){
            int cx,cy,r; // 각 행성계의 x좌표, y좌표, 반지름
            cin >> cx >> cy >> r;
            Is_faced(cx,cy,r,cnt);
        }

        cout << cnt << '\n';
    }
}
