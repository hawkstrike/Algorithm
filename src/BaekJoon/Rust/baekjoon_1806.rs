use std::cmp::min;
use std::io::stdin;

pub fn baekjoon_1806() {
    let n_s: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, s) = (n_s[0], n_s[1]);
    let mut arr: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (mut left, mut sum, mut min_value) = (0, 0, usize::MAX);
    
    arr.insert(0, 0);
    
    for i in 1..=n {
        sum += arr[i];
        
        while sum >= s {
            min_value = min(min_value, i - left);
            left += 1;
            sum -= arr[left];
        }
    }
    
    println!("{}", if min_value == usize::MAX { 0 } else { min_value });
}