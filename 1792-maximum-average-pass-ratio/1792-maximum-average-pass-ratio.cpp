class Solution {
public:
    double calculateGain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }

    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        priority_queue<pair<double, pair<int, int>>> maxHeap;
        for (auto clas : classes) {
            maxHeap.push({calculateGain(clas[0], clas[1]), {clas[0], clas[1]}});
        }

        while (extraStudents--) {
            auto topElement = maxHeap.top();
            maxHeap.pop();
            int pass = topElement.second.first;
            int total = topElement.second.second;
            maxHeap.push({calculateGain(pass + 1, total + 1), {pass + 1, total + 1}});
        }

        double totalPassRatio = 0;
        while (!maxHeap.empty()) {
            auto topElement = maxHeap.top();
            maxHeap.pop();
            totalPassRatio += (double)topElement.second.first / topElement.second.second;
        }

        return totalPassRatio / classes.size();
    }
};