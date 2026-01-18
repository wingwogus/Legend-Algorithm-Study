#include <iostream>
#include <algorithm>
using namespace std;

int bottom[100001], top[100001];
int Min = 200002;
int N, H, tmp, cnt;

int main() {
    cin >> N >> H;

    // 석순(bottom)과 종유석(top) 입력 받기
    for (int i = 0; i < N / 2; i++)
    {
        cin >> bottom[i] >> top[i];
    }

    sort(bottom, bottom + (N / 2)); // 석순(bottom) 정렬
    sort(top, top + (N / 2)); // 종유석(top) 정렬

    // 각 높이 기준으로 부딪히는 장애물 개수 확인
    for (int pivot = 1; pivot <= H; pivot++)
    {
        tmp = lower_bound(bottom, bottom + (N / 2), pivot) - bottom; // 석순 중에서 안 부딪힌 거
        tmp += upper_bound(top, top + (N / 2), H - pivot) - top; // 종유석 중에서 안 부딪힌 거
        tmp = N - tmp;  // 전체에서 안 부딪힌 거 빼버리기 => 부딪힌 것들

        // 보다 적게 장애물을 부딪히는 경우
        if (Min > tmp)
        {
            Min = tmp;
            cnt = 1;
        }
        // 현재 기준이 되는 최솟값과 동일한 경우
        else if (Min == tmp)
        {
            cnt++;
        }
    }
    cout << Min << " " << cnt;

    return 0;
}