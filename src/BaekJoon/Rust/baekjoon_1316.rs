use std::io::stdin;

pub fn baekjoon_1316() {
    let mut n: usize = stdin().lines().next().unwrap().unwrap().trim().to_string()
        .parse::<usize>().unwrap();
    let mut count: i32 = 0;
    
    while n > 0 {
        n -= 1;
        
        let char_vector: Vec<char> = stdin().lines().next().unwrap().unwrap().chars().collect::<Vec<char>>();
        let mut arr: Vec<i32> = vec![0; 26];
        let mut flag: bool = false;
        
        for index in 0..char_vector.len() - 1 {
            if char_vector[index] == char_vector[index + 1] {
                continue;
            }
            
            let arr_index: usize = char_vector[index] as u8 as usize - 97;
            
            if arr[arr_index] == 0 {
                arr[arr_index] += 1;
            } else {
                flag = true;
            }
        }
        
        if !flag && arr[char_vector[char_vector.len() - 1] as u8 as usize - 97] == 0 {
            count += 1;
        }
    }
    
    println!("{}", count);
}