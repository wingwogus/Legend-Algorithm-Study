#include<iostream>
#include<cmath> // pow 함수 (제곱)
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int x1, y1, x2, y2;
		cin >> x1 >> y1 >> x2 >> y2; // 출발점, 도착점

		int n; // 행성계의 개수
		cin >> n;

		int in = 0;
		int out = 0;

		for (int j = 0; j < n; j++) {
			int x, y, r;
			cin >> x >> y >> r;

			// 출발점을 포함하는 행성계는 이탈, 도착점을 포함하는 행성계는 진입
			if (pow(x - x1, 2) + pow(y - y1, 2) < r * r) { // 출발점이 행성계 안에 있고
				if (pow(x - x2, 2) + pow(y - y2, 2) > r * r) { // 도착점이 행성계 밖에 있는경우
					out++; // 이탈
				}
			}
			if (pow(x - x2, 2) + pow(y - y2, 2) < r * r) { // 도착점이 행성계 안에 있고
				if (pow(x - x1, 2) + pow(y - y1, 2) > r * r) { // 출발점이 행성계 밖에 있는경우
					in++; // 진입
				}
			}
		}
		cout << in + out << "\n";
	}
	return 0;
}