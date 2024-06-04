use std::io::{BufRead, stdin};

pub fn baekjoon_1644() {
    let n: usize = stdin().lock().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut field: Vec<i32> = vec![0; n + 2];
    
    for i in 2..=n {
        for j in (2 * i..=n).step_by(i) {
            field[j] = 1;
        }
    }
    
    let (mut left, mut right, mut sum, mut count) = (2, 2, 2, 0);
    
    while left <= right && right <= n {
        if sum == n {
            count += 1;
            right += 1;
            
            while field[right] != 0 {
                right += 1;
            }
            
            sum += right;
        } else if sum < n {
            right += 1;
            
            while field[right] != 0 {
                right += 1;
            }
            
            sum += right;
        } else if sum > n {
            sum -= left;
            left += 1;
            
            while field[left] != 0 {
                left += 1;
            }
        }
    }
    
    println!("{}", count);
}