use std::io::stdin;

pub fn baekjoon_1764() {
    let n_m: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (mut n, mut m) = (n_m[0], n_m[1]);
    let mut str1: Vec<String> = Vec::new();
    let mut str2: Vec<String> = Vec::new();
    
    while n > 0 {
        n -= 1;
        
        let str: String = stdin().lines().next().unwrap().unwrap();
        
        str1.push(str);
    }
    
    while m > 0 {
        m -= 1;
        
        let str: String = stdin().lines().next().unwrap().unwrap();
        
        str2.push(str);
    }
    
    str1.sort();
    str2.sort();
    
    let mut result: Vec<String> = Vec::new();
    
    for i in 0..n_m[0] {
        match str2.binary_search(&str1[i]) {
            Ok(index) => {
                result.push(String::from(&str2[index]));
            },
            Err(_) => {}
        }
    }
    
    println!("{}", result.len());
    
    result.iter().for_each(|(value)| println!("{}", value))
}