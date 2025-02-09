# SimpleProject

## 專案描述
SimpleProject 是一個展示基本 Spring Boot 框架和 Spring MVC 架構的範例專案。資料庫使用 MySQL 官方提供的 Sakila Sample Database 作為基礎，實現資料的讀取、新增、修改、刪除等功能。本專案同時滿足業界常見的前後端分離需求，專注於 C（Controller）與 M（Model）部分，並提供 RESTful API。

## 功能介紹
1. 基本的 CRUD 功能。
2. 工作人員登入登出的權限管理功能。

## 使用技術
本專案使用 Java 開發，基於 Spring Boot 框架，並使用內置的 Tomcat Server 運行。
以下是各區塊使用到的技術：

### Controller (C)
- **RESTful API**：所有請求 URL 按照 RESTful API 標準編寫。
- **參數與物件驗證**：使用 `@RequestParam` 或 `@RequestBody` 並搭配自定義方法或 `jakarta.validation.Valid` 驗證，避免錯誤發生。
- **安全性管理**：
  - Spring Security：進行權限審核與跨域資源管理（CORS）。
  - JSON Web Token (JWT)：部分重要 API 需要權限認證，需傳送 Token 並通過核對後才會放行。

### Model (M)
- **資料庫互動**：使用 MyBatis 3 技術，透過 XML 文件映射資料庫進行 CRUD 操作。
- **緩存技術**：
  - 使用 Redis 作為緩存工具。
  - 整合 Spring Cache Manager 與 Redis Server，實現 Spring Boot、MyBatis 和 Redis 的高效結合。

### 其他技術
- **異常處理**：透過 `@ControllerAdvice` 自定義統一的異常攔截器，集中管理並方便除錯。

## 安裝步驟
目前暫不提供安裝步驟。

## 使用方式
目前暫不提供使用方式。

## 貢獻指南
歡迎對本專案進行貢獻！如需貢獻代碼，請遵循以下指導：
1. Fork 此專案到你的儲存庫。
2. 建立新分支進行功能開發或修復（例如：`feature/功能名稱`）。
3. 提交 Pull Request 時，請提供詳細的修改描述。

## 授權條款
目前未指定授權條款。如需使用或分發此專案，請聯繫作者取得授權。

## 其他資訊
本專案強調系統效能與穩定性：
- 資料庫查詢避免使用 `*`，確保高效資料提取。
- 使用 `switch` 替代巢狀 `if` 結構，簡化條件判斷。
- 嚴格管理變數宣告，避免不必要的記憶體消耗與內存洩漏。

如果有任何問題或建議，歡迎聯繫作者！ 


