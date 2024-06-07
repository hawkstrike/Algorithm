use std::io::stdin;

pub fn baekjoon_1722() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut permutation_vector: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let order: usize = permutation_vector[0];
    
    let mut field: Vec<i64> = (1..=20).map(|i| (1..i).product()).collect::<Vec<i64>>();
    let mut checked: Vec<bool> = vec![false; 21];
    let mut arr = vec![0; n];
    
    if order == 2 {
        for index in 1..permutation_vector.len() {
            arr[index - 1] = permutation_vector[index];
        }
        
        let mut result: i64 = 0;
        
        for i in 0..n {
            for j in 1..arr[i] {
                if !checked[j] {
                    result += field[n - i - 1];
                }
            }
            
            checked[arr[i]] = true;
        }
        
        println!("{}", result + 1);
    } else {
        let mut k: i64 = permutation_vector[1] as i64;
        
        for i in 0..n {
            for j in 1..=n {
                if checked[j] {
                    continue;
                }
                
                if field[n - i - 1] < k {
                    k -= field[n - i - 1];
                } else {
                    arr[i] = j;
                    checked[j] = true;
                    break;
                }
            }
        }
        
        for index in 0..n {
            print!("{} ", arr[index]);
        }
        
        println!();
    }
}