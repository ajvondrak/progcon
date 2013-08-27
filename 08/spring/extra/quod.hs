module Main where

import Char

parseInt :: String -> Int
parseInt = read

digits n = map digitToInt $ show n

quodigious n = all (flip notElem "01") (show n) &&
               (mod n $ sum $ digits n) == 0    &&
               (mod n $ product $ digits n) == 0

nDigitNums n = [10^(n-1) .. 10^n-1]

quodOutput = flip (++) "\n" . concatMap quodOutput' . nDigitNums . parseInt
  where quodOutput' n = if quodigious n then show n ++ "\n" else ""

main = interact (concatMap (concatMap quodOutput . words) . lines)
