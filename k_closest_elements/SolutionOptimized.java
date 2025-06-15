package k_closest_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionOptimized {
    public List<Integer> findClosestElements(int[] nums, int k, int target) {
        // Bước 1: Tìm vị trí khởi đầu bằng Binary Search
        // Arrays.binarySearch trả về chỉ số của phần tử nếu tìm thấy.
        // Nếu không tìm thấy, nó trả về -(insertion point) - 1.
        // insertion point là chỉ số mà phần tử đó sẽ được chèn vào nếu nó có trong mảng,
        // giữ cho mảng vẫn được sắp xếp.
        int idx = Arrays.binarySearch(nums, target);

        // Nếu x không có trong mảng, idx sẽ âm. Chuyển nó thành insertion point.
        if (idx < 0) {
            idx = -(idx + 1);
        }

        // Bước 2: Sử dụng Two Pointers để mở rộng cửa sổ
        // left sẽ là chỉ số của phần tử có thể nhỏ hơn x
        // right sẽ là chỉ số của phần tử có thể lớn hơn hoặc bằng x
        int left = idx - 1;
        int right = idx;

        // Đây là danh sách tạm thời để lưu trữ các phần tử được chọn
        List<Integer> tempResult = new ArrayList<>();

        // Lặp k lần để chọn đủ k phần tử
        while (tempResult.size() < k) {
            // Trường hợp left đã ra khỏi biên mảng
            if (left < 0) {
                tempResult.add(nums[right]);
                right++;
            }
            // Trường hợp right đã ra khỏi biên mảng
            else if (right >= nums.length) {
                tempResult.add(nums[left]);
                left--;
            }
            // Cả left và right đều hợp lệ, so sánh độ gần
            else {
                int diffLeft = Math.abs(nums[left] - target);
                int diffRight = Math.abs(nums[right] - target);

                if (diffLeft <= diffRight) { // Ưu tiên số nhỏ hơn nếu khoảng cách bằng nhau
                    tempResult.add(nums[left]);
                    left--;
                } else {
                    tempResult.add(nums[right]);
                    right++;
                }
            }
        }

        // Sắp xếp lại danh sách kết quả cuối cùng để đảm bảo thứ tự tăng dần
        Collections.sort(tempResult);

        return tempResult;
    }
}