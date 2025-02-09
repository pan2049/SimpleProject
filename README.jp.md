# SimpleProject

* [English](README.md)
* [繁體中文版README.md](README.zh-TW.md)
* [日本語版README.md](README.jp.md)

## プロジェクトの説明
SimpleProject は、Spring Boot フレームワークと Spring MVC アーキテクチャの基本構造を示すサンプルプロジェクトです。MySQL の公式サンプルデータベースである Sakila Sample Database を使用し、データの取得、作成、更新、削除の機能を実装しています。本プロジェクトは、業界標準のフロントエンドとバックエンドの分離要件を満たし、コントローラー（C）とモデル（M）部分に重点を置き、RESTful API を提供します。

## 機能
1. 基本的な CRUD（作成、読み取り、更新、削除）機能。
2. ユーザーの認証（ログイン・ログアウト機能）。

## 使用技術
本プロジェクトは Java を使用して開発されており、Spring Boot フレームワークを基盤とし、組み込みの Tomcat サーバーで動作します。各モジュールで使用されている主要な技術は以下の通りです。

### Controller（C）
- **RESTful API**：すべてのリクエスト URL は RESTful API 標準に準拠。
- **パラメータとオブジェクトのバリデーション**：`@RequestParam` および `@RequestBody` を `jakarta.validation.Valid` やカスタムメソッドを用いて検証し、エラーを防止。
- **セキュリティ管理**：
  - Spring Security：認証処理と CORS（クロスオリジンリソース共有）を管理。
  - JSON Web Token（JWT）：一部の API エンドポイントは認証が必要であり、発行されたトークンを検証してアクセスを許可。

### Model（M）
- **データベース操作**：MyBatis 3 を使用して、SQL データベースと XML 構成を通じた CRUD 操作を実装。
- **キャッシュ機能**：
  - Redis をキャッシュツールとして利用。
  - Spring Cache Manager と Redis Server を統合し、Spring Boot、MyBatis、Redis のパフォーマンスを最適化。

### その他の技術
- **例外処理**：`@ControllerAdvice` を使用して統一的な例外処理を実装し、エラーログの管理とデバッグを簡素化。

## インストール手順
インストール手順は現在提供されていません。

## 使用方法
使用方法については現在提供されていません。

## 貢献ガイドライン
本プロジェクトへの貢献を歓迎します！貢献する場合は、以下の手順に従ってください。
1. リポジトリをフォーク。
2. 新しいブランチを作成（例：`feature/機能名`）。
3. プルリクエストを送信し、変更内容の詳細な説明を記載。

## ライセンス
現在、特定のライセンスは指定されていません。本プロジェクトの使用または配布を希望する場合は、作者へお問い合わせください。

## その他の情報
本プロジェクトはシステムのパフォーマンスと安定性を重視しています。
- データベースクエリで `*` を使用せず、効率的なデータ取得を実現。
- ネストされた `if` 構造の代わりに `switch` を活用し、可読性とパフォーマンスを向上。
- 変数宣言を厳密に管理し、不要なメモリ消費を抑え、メモリリークを防止。

ご質問やご提案がありましたら、お気軽にお問い合わせください！

