use std::char::from_digit;
use std::collections::VecDeque;
use std::io::stdin;

pub fn baekjoon_1963() {
    let mut n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut field: Vec<bool> = vec![false; 10000];
    
    for i in 2..=1000 {
        if !field[i] {
            let mut j = 2 * i;
            
            while j < 10000 {
                field[j] = true;
                j += i;
            }
        }
    }
    
    while n > 0 {
        n -= 1;
        
        let start_end_vector: Vec<usize> = stdin().lines().next().unwrap().unwrap()
            .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
        let (start, end) = (start_end_vector[0], start_end_vector[1]);
        
        bfs(&field, start, end);
    }
}

fn bfs(field: &Vec<bool>, start: usize, end: usize) {
    let mut queue: VecDeque<usize> = VecDeque::new();
    let mut count: i32 = 0;
    let mut flag: bool = false;
    let mut visited: Vec<bool> = vec![false; 10000];
    
    queue.push_back(start);
    
    let mut queue_size: usize = queue.len();
    
    while !queue.is_empty() {
        let minority: usize = queue.pop_front().unwrap();
        
        if minority == end {
            println!("{}", count);
            flag = true;
            break;
        }
        
        for i in 0..4 {
            let str: String = minority.to_string();
            
            for j in 0..=9 {
                if i != 0 || j != 0 {
                    let mut chars: Vec<char> = str.chars().collect();
                    
                    chars[i] = from_digit(j, 10).unwrap();
                    
                    let temp: usize = chars.into_iter().collect::<String>().parse().unwrap();
                    
                    if !field[temp] && !visited[temp] {
                        queue.push_back(temp);
                        visited[temp] = true;
                    }
                }
            }
        }
        
        queue_size -= 1;
        
        if queue_size == 0 {
            queue_size = queue.len();
            count += 1;
        }
    }
    
    if !flag {
        println!("impossible");
    }
}