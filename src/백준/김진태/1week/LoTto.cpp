#include <iostream>
#include <vector>
#include <iterator>


using namespace std;

void lotto_recurison(int start, int lottoNum[], int nsize, int depth);

int result_num[6];

int main() {
    // 백준 제출용 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k = 1; // 고를 수 갯수 {6~13}
    int cases = 0;
    int lottoNum[13]; // 집합 {1~49} 사이 숫자들만 오름 차순임

    while (k != 0) {
        cin >> k;
        if (k == 0) {
            // 0 입력시 반복문 빠져나오게
            break;
        }
        for (int i = 0; i < k; i++) {
            cin >> lottoNum[i];
        }

        fill(result_num, result_num + 6, 0); // 모조리 0
        lotto_recurison(0, lottoNum, k, 0);
        cout << "\n";
    }

    return 0;
}

void lotto_recurison(int start, int lottoNum[], int k, int depth) {
    if (depth == 6) {
        // 6개까지니까
        for (int i = 0; i < 6; i++) {
            cout << result_num[i] << " ";
        }
        cout << "\n";
        return; // 출력 후 상위로 올라가도록 (베이스 케이스)
    }
    // lottoNum에는 집합이 있는거임 (1,2,3,4,5,6,7)
    for (int i = start; i < k; i++) {
        result_num[depth] = lottoNum[i];
        lotto_recurison( i+1 , lottoNum, k, depth + 1);
    }
}
