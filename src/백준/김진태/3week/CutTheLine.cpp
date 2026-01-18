#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long k, n; // 영식이가 가지고 있는 랜선 개수, 필요한 랜선 개수
long long max_length = 0;
bool is_cutable(vector<long long> &line_length, long long mid) {
    long long sum = 0;
    for (long long i = 0; i < line_length.size(); i++) {
        sum += line_length[i] / mid;
    }
    if (sum >= n) {
        return true;
    }
    return false;
}

long long cut_line(vector<long long> &line_length) {
    long long left = 1;
    long long right = line_length[line_length.size() - 1]; // 가장 큰 길이

    while (left <= right) {
        long long mid = (left + right) / 2; // 최대 최소의 중간 값
        if (is_cutable(line_length, mid)) {
            max_length = mid;
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return max_length;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> k >> n;
    vector<long long> line_length; // k 랜선 길이를 가질 1차원 벡터

    for (int i = 0; i < k; i++) {
        long long length;
        cin >> length; // 각 길이 입력
        line_length.push_back(length);
    }
    sort(line_length.begin(), line_length.end()); // 오름차순 정렬

    max_length = cut_line(line_length);

    cout << max_length << '\n';
}

// k개의 각 랜선들을 잘라서 최대크기의 랜선 N개를 만들어야되는거임
